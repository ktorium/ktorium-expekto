pluginManagement {
    plugins {
        kotlin("multiplatform") version "1.9.10" apply false
    }
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "expekto"

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS

    repositories {
        mavenCentral()
    }
}

includeModule("core")

fun includeModule(name: String) {
    include(name)
    project(":${name}").projectDir = File("modules/$name")
}
