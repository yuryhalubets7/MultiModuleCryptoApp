import extensions.*

plugins {
    id(GradlePlugins.AndroidLibrary)
    id(GradlePlugins.KotlinAndroid)
}

android {
    configureDefaultConfig()
    compileSdk = Configs.CompileSdk

    setCompileOptions()
    configureKotlinCompile()

    enableCompose()
}

dependencies {
    implementation(Dependencies.Compose.Ui)
}