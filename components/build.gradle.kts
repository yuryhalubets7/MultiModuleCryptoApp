import extensions.*

plugins {
    id(GradlePlugins.AndroidLibrary)
    id(GradlePlugins.KotlinAndroid)
}

android {
    compileSdk = Configs.CompileSdk
    configureDefaultConfig()

    setCompileOptions()
    configureKotlinCompile()

    enableCompose()
}

dependencies {
    implementation(project(Modules.Core.Domain))
    implementation(Dependencies.Compose.Ui)
    implementation(Dependencies.Compose.Material)
    implementation(Dependencies.Compose.UiPreview)
}