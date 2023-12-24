import org.gradle.api.tasks.wrapper.Wrapper.DistributionType.ALL

allprojects {
    group = "com.ktorium.expekto"

    configurations.all {
        resolutionStrategy {
            failOnNonReproducibleResolution()
        }
    }
}

tasks {
    named<Wrapper>("wrapper") {
        gradleVersion = project.property("gradle-wrapper.version") as String
        distributionType = ALL
    }
}
