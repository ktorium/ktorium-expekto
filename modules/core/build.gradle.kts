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
    js(IR) {
        browser()
        nodejs()
    }

    sourceSets {
        all {
            languageSettings.apply {
                apiVersion = "2.0"
                languageVersion = "2.0"
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
