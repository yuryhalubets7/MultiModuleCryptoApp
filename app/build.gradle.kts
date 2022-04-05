import extensions.*

plugins {
    id(GradlePlugins.AndroidApplication)
    id(GradlePlugins.KotlinAndroid)
    id(GradlePlugins.KotlinKapt)
    id(GradlePlugins.Hilt)
}

android {
    compileSdk = Configs.CompileSdk

    configureDefaultConfig()

    setCompileOptions()
    configureKotlinCompile()

    setSigningConfigs(project)

    buildTypes.apply {
        getByName("release") {
            signingConfig = signingConfigs.getByName("signingConfigRelease")
            isDebuggable = false
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            buildConfigStringField("BASE_URL", Configs.Release.BASE_URL)
        }
        getByName("debug") {
            isTestCoverageEnabled = true
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            buildConfigStringField("BASE_URL", Configs.Debug.BASE_URL)
        }
    }

    buildFeatures.apply {
        compose = true
    }

    composeOptions.apply {
        kotlinCompilerExtensionVersion = Versions.ComposeCompiler
    }
}

dependencies {
    implementation(project(Modules.DI))
    implementation(project(Modules.Navigation))
    implementation(project(Modules.Core.DI))

    implementation(Dependencies.DI.HiltAndroid)
    kapt(Dependencies.DI.HiltCompiler)

    implementation(Dependencies.Compose.Ui)
    implementation(Dependencies.Compose.Material)
    implementation(Dependencies.Compose.UiPreview)
    implementation(Dependencies.Compose.Activity)

    testImplementation(project(Modules.Util.Tests))
    testImplementation(Dependencies.Test.Mockk)
}
