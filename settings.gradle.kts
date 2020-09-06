import java.nio.file.Files.isReadable

pluginManagement {
    plugins {
        kotlin("jvm") version "1.6.10" apply false
        id("io.gitlab.arturbosch.detekt") version "1.19.0" apply false
    }
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

enableFeaturePreview("VERSION_CATALOGS")

rootProject.name = "expekto"

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        mavenCentral()
    }
}

rootDir.resolve("modules")
    .walkTopDown()
    .maxDepth(1)
    .filter { it.isDirectory && isReadable(it.resolve("build.gradle.kts").toPath()) }
    .forEach {
        include(it.name)
        project(":${it.name}").projectDir = it
    }
