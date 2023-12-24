@file:Suppress("UnstableApiUsage")

pluginManagement {
    plugins {
        kotlin("multiplatform") version "1.9.22" apply false
    }
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS

    repositories {
        mavenCentral()
    }
}

run {
    rootProject.name = "expekto"
}

includeModule("core")

fun includeModule(name: String) {
    include(name)
    project(":${name}").projectDir = File("modules/$name")
}
