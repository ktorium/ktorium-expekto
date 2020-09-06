import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    jacoco
    id("io.gitlab.arturbosch.detekt")
}

configurations.all {
    resolutionStrategy {
        failOnNonReproducibleResolution()
    }
}

dependencies {

    testImplementation(platform("org.junit:junit-bom:5.8.2"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

kotlin {
    sourceSets {
        all {
            languageSettings.apply {
                apiVersion = "1.6"
                languageVersion = "1.6"
                progressiveMode = true
            }
        }
        main {
            kotlin.srcDirs("src/main/kotlinX")
        }
        test {
            kotlin.srcDirs(listOf(
                "src/test/kotlinX",
                "src/testFixtures/kotlin"
            ))
        }
    }
}

jacoco {
    toolVersion = "0.8.7"
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
        }

        val integrationTest by registering(JvmTestSuite::class) {
            sources {
                java {
                    setSrcDirs(listOf("src/integrationTest/kotlin"))
                }
            }

            dependencies {
                implementation(project)
            }

            targets {
                all {
                    testTask.configure {
                        shouldRunAfter(test)
                    }
                }
            }
        }
    }
}

detekt {
    buildUponDefaultConfig = true
    allRules = false
    config = files("${rootProject.projectDir}/config/detekt/detekt.yml")
}

tasks {
    withType<KotlinCompile>().configureEach {
        kotlinOptions {
            apiVersion = "1.6"
            languageVersion = "1.6"
            jvmTarget = "11"
            allWarningsAsErrors = true
            freeCompilerArgs = listOf(
                "-Xjsr305=strict"
            )
        }
    }

    withType<Detekt>().configureEach {
        reports {
            html.required.set(true)
            xml.required.set(true)
            txt.required.set(false)
            sarif.required.set(false)
        }
    }

    test {
        finalizedBy(jacocoTestReport)
    }

    jacocoTestReport {
        reports {
            xml.required.set(false)
            csv.required.set(false)
            html.outputLocation.set(layout.buildDirectory.dir("jacocoHtml"))
        }

        dependsOn(test)
        finalizedBy(jacocoTestCoverageVerification)
    }

    jacocoTestCoverageVerification {
        dependsOn(jacocoTestReport)

        violationRules {
            rule {
                limit {
                    minimum = "0.8".toBigDecimal()
                }
            }
        }
    }

    check {
        dependsOn(testing.suites.named("integrationTest"))
    }
}
