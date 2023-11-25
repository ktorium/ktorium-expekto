plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

run {
    group = "com.ktorium.expekto.gradle.plugins.settings"

    description = "Gradle settings extensions"
}

sourceSets {
    main {
        kotlin {
            srcDir("src/main/kotlinX")
        }
    }
}

gradlePlugin {
    plugins {
        create("settings-plugins") {
            id = "settings-plugins"
            implementationClass = "com.ktorium.expekto.gradle.plugins.settings.SettingsPlugin"
        }
    }
}
