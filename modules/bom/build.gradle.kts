plugins {
    `java-platform`
}

description = "Bill of materials to make sure a consistent set of versions is used for Expekto."

dependencies {
    constraints {
        rootProject.subprojects {
            val module = this

            if (!module.name.startsWith("bom")) {
                module.plugins.withId("maven-publish") {
                    api(module)
                }
            }
        }
    }
}
