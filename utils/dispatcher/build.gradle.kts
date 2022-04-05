import extensions.api
import extensions.implementation
import extensions.kapt

plugins {
    id(GradlePlugins.KotlinLibrary)
    id(GradlePlugins.KotlinKapt)
}

dependencies {
    api(Dependencies.Coroutine.Core)

    implementation(Dependencies.DI.DaggerCore)
    kapt(Dependencies.DI.DaggerCompiler)
}