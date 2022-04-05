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
}

dependencies {
    api(project(Modules.Domain))
    implementation(project(Modules.Remote))
    implementation(project(Modules.Util.Dispatcher))
    
    implementation(Dependencies.DI.HiltAndroid)
    kapt(Dependencies.DI.HiltCompiler)
}
