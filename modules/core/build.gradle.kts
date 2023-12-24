plugins {
    kotlin("multiplatform")
}

kotlin {
    explicitApi()

    jvm()

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
