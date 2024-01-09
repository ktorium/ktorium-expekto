@file:Suppress("UnstableApiUsage")

pluginManagement {
    plugins {
        kotlin("multiplatform") version "1.9.22" apply false
        id("io.gitlab.arturbosch.detekt") version "1.23.4" apply false
    }
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    includeBuild("build-logic")
}

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS

    repositories {
        mavenCentral()
    }
}

rootProject.name = "expekto"

includeModule("core")

fun includeModule(name: String) {
    include(name)
    project(":${name}").projectDir = File("modules/$name")
}
