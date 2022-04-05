pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://plugins.gradle.org/m2/")
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://plugins.gradle.org/m2/")
    }
}

rootProject.name = "ComposeCryptoApp"
include(":app")
include(":domain")
include(":remote")

include(":core")
include(":core:domain")
include(":core:ui")
include(":core:di")

include(":di")

include(":utils")
include(":utils:dispatcher")
include(":utils:tests")

include(":components")
include(":navigation")

include(":feature")
include(":feature:coin")
include(":feature:coin:detail")
include(":feature:coin:list")
