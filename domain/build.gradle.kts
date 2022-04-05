import extensions.*
import extensions.kapt

plugins {
    id(GradlePlugins.KotlinLibrary)
    id(GradlePlugins.KotlinKapt)
}

dependencies {
    api(project(Modules.Core.Domain))

    implementation(Dependencies.DI.DaggerCore)
    kapt(Dependencies.DI.DaggerCompiler)

    implementation(Dependencies.Coroutine.Core)

    testImplementation(project(Modules.Util.Tests))
    testImplementation(Dependencies.Test.Mockk)
}
