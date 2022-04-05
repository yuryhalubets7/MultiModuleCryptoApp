plugins {
    id(GradlePlugins.VersionCheck)
    id(GradlePlugins.CodeAnalyze)
    id(GradlePlugins.TasksTest)
}

tasks.named<Wrapper>("wrapper") {
    distributionType = Wrapper.DistributionType.BIN
    gradleVersion = Versions.Gradle
}