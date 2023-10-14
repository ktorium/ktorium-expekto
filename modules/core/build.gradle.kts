plugins {
    kotlin("multiplatform")
}

configurations.all {
    resolutionStrategy {
        failOnNonReproducibleResolution()
    }
}

kotlin {
    explicitApi()

    jvm()

    sourceSets {
        all {
            languageSettings.apply {
                apiVersion = "1.9"
                languageVersion = "1.9"
                progressiveMode = true
            }
        }

        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
