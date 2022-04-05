object Dependencies {

    object Compose {
        const val Ui = "androidx.compose.ui:ui:${Versions.Compose}"
        const val Material = "androidx.compose.material:material:${Versions.Compose}"
        const val UiPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.Compose}"
        const val Activity = "androidx.activity:activity-compose:${Versions.ComposeActivity}"
        const val Junit4 = "androidx.compose.ui:ui-test-junit4:${Versions.Compose}"
        const val UiTooling = "androidx.compose.ui:ui-tooling:${Versions.Compose}"
        const val ViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Lifecycle}"
        const val Navigation =
            "androidx.navigation:navigation-compose:${Versions.ComposeNavigation}"
        const val FlowLayout =
            "com.google.accompanist:accompanist-flowlayout:${Versions.AccompanistFlow}"
    }

    object AndroidX {
        const val CoreKtx = "androidx.core:core-ktx:${Versions.CoreKtx}"
        const val AppCompat = "androidx.appcompat:appcompat:${Versions.AppCompat}"
        const val Material = "com.google.android.material:material:${Versions.Material}"
    }

    object Lifecycle {
        const val ViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Lifecycle}"
        const val LiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Lifecycle}"
        const val Runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Lifecycle}"
    }

    object Coroutine {
        const val Core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Coroutine}"
        const val Android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Coroutine}"
    }

    object DI {
        const val DaggerCore = "com.google.dagger:dagger:${Versions.Dagger}"
        const val DaggerCompiler = "com.google.dagger:dagger-compiler:${Versions.Dagger}"
        const val HiltAndroid = "com.google.dagger:hilt-android:${Versions.Dagger}"
        const val HiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.Dagger}"
        const val Lifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.HiltCompose}"
        const val NavigationCompose =
            "androidx.hilt:hilt-navigation-compose:${Versions.HiltCompose}"
    }

    object Network {
        const val BaseRetrofit = "com.squareup.retrofit2:retrofit:${Versions.Retrofit}"
        const val Gson = "com.squareup.retrofit2:converter-gson:${Versions.Retrofit}"
        const val Okhttp = "com.squareup.okhttp3:okhttp:${Versions.Okhttp}"
        const val Interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.Okhttp}"
    }

    object CodeQuality {
        const val DetektFormatting =
            "io.gitlab.arturbosch.detekt:detekt-formatting:${Versions.Detekt}"
    }

    object Test {
        const val Junit = "junit:junit:${Versions.Junit}"
        const val JunitExt = "androidx.test.ext:junit:${Versions.JunitExt}"
        const val EspressoCore = "androidx.test.espresso:espresso-core:${Versions.EspressoCore}"
        const val Coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Coroutine}"
        const val Okhttp = "com.squareup.okhttp3:mockwebserver:${Versions.Okhttp}"
        const val Mockk = "io.mockk:mockk:${Versions.Mockk}"
    }
}