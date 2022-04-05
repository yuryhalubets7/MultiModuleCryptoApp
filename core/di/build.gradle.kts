import extensions.implementation
import extensions.kapt

plugins {
    id(GradlePlugins.KotlinLibrary)
    id(GradlePlugins.KotlinKapt)
}

dependencies {
    implementation(Dependencies.DI.DaggerCore)
    kapt(Dependencies.DI.DaggerCompiler)
}