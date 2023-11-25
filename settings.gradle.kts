pluginManagement {
    plugins {
        kotlin("multiplatform") version "1.9.20" apply false
    }
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    includeBuild("gradle/plugins")
}

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS

    repositories {
        mavenCentral()
    }
}

plugins {
    id("settings-plugins")
}

run {
    rootProject.name = "expekto"
}

listOf(
    "core"
).forEach {
    includeModule("modules", it)
}

fun includeModule(moduleName: String, projectName: String) {
    include(projectName)
    project(":$projectName").projectDir = file("$moduleName/$projectName")
}
