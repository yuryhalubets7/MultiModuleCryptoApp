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
    api(project(Modules.Core.DI))

    implementation(Dependencies.DI.DaggerCore)
    kapt(Dependencies.DI.DaggerCompiler)

    implementation(Dependencies.Coroutine.Core)

    implementation(Dependencies.Network.BaseRetrofit)
    implementation(Dependencies.Network.Gson)
    implementation(Dependencies.Network.Okhttp)
    implementation(Dependencies.Network.Interceptor)

    testImplementation(project(Modules.Util.Tests))
    testImplementation(Dependencies.Test.Mockk)
}