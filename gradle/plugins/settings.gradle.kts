import org.gradle.api.initialization.resolve.RepositoriesMode.FAIL_ON_PROJECT_REPOS

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode = FAIL_ON_PROJECT_REPOS

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

run {
    rootProject.name = "plugins"
}

include("settings-plugins")
