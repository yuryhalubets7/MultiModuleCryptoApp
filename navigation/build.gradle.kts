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
    implementation(project(Modules.Feature.Coin.Detail))
    implementation(project(Modules.Feature.Coin.List))

    implementation(Dependencies.Compose.Navigation)
    implementation(Dependencies.DI.NavigationCompose)
}