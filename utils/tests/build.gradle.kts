import extensions.api

plugins {
    id(GradlePlugins.KotlinLibrary)
    id(GradlePlugins.KotlinKapt)
}

dependencies {
    api(project(Modules.Util.Dispatcher))

    api(Dependencies.Test.Junit)
    api(Dependencies.Test.Coroutine)
}