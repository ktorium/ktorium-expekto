import org.gradle.api.tasks.wrapper.Wrapper.DistributionType.ALL

allprojects {
    group = "com.ktorium.expekto"
    version = "1.0-SNAPSHOT"
}

tasks {
    named<Wrapper>("wrapper") {
        gradleVersion = project.property("gradle-wrapper.version") as String
        distributionType = ALL
    }
}
