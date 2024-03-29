import org.jetbrains.kotlin.gradle.plugin.getKotlinPluginVersion

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

configurations.all {
    resolutionStrategy {
        failOnNonReproducibleResolution()
    }
}

sourceSets {
    main {
        kotlin {
            srcDirs("src/main/kotlinX")
        }
    }
}

kotlin {
    explicitApi()

    jvmToolchain {
        val mainJvmCompiler = JavaLanguageVersion.of(21) //providers.gradleProperty("kotlin.javaToolchain.mainJvmCompiler").map(JavaLanguageVersion::of)

        languageVersion = mainJvmCompiler
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${getKotlinPluginVersion()}")
}

gradlePlugin {
    plugins {
        register("BuildProjectPlugin") {
            id = "build-project-plugin"
            implementationClass = "org.ktorium.kotlin.gradle.plugins.build.BuildProjectPlugin"
        }
    }
}
