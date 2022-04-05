import extensions.*

plugins {
    id(GradlePlugins.AndroidLibrary)
    id(GradlePlugins.KotlinAndroid)
    id(GradlePlugins.KotlinKapt)
}

android {
    compileSdk = Configs.CompileSdk
    configureDefaultConfig()

    setCompileOptions()
    configureKotlinCompile()

    enableCompose()
}

dependencies {
    implementation(project(Modules.DI))
    implementation(project(Modules.Util.Dispatcher))
    implementation(project(Modules.Components))
    implementation(project(Modules.Core.Ui))

    implementation(Dependencies.Lifecycle.ViewModel)
    implementation(Dependencies.Lifecycle.Runtime)

    implementation(Dependencies.Compose.Ui)
    implementation(Dependencies.Compose.Material)
    implementation(Dependencies.Compose.FlowLayout)

    implementation(Dependencies.DI.HiltAndroid)
    kapt(Dependencies.DI.HiltCompiler)

    testImplementation(project(Modules.Util.Tests))
    testImplementation(Dependencies.Test.Mockk)
}