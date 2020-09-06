import org.gradle.api.tasks.wrapper.Wrapper.DistributionType.ALL

plugins {
    kotlin("jvm") version "1.6.10" apply false
    id("io.gitlab.arturbosch.detekt") version "1.19.0"
}

allprojects {
    group = "com.ktorium.expekto"
    version = "1.0-SNAPSHOT"
}

tasks {
    named<Wrapper>("wrapper") {
        gradleVersion = project.property("gradle-wrapper.version") as String
        distributionType = ALL
    }
}
