package extensions

import Configs
import Versions
import com.android.build.api.dsl.BuildType
import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.io.FileInputStream
import java.util.*

fun Project.configureKotlinCompile() {
    project.tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
            allWarningsAsErrors = true
            freeCompilerArgs = Configs.FreeCompilerArgs
        }
    }
}

fun BuildType.buildConfigStringField(name: String, value: String) {
    this.buildConfigField("String", name, "\"$value\"")
}

fun BaseExtension.setCompileOptions() {
    compileOptions.apply {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

fun BaseExtension.setSigningConfigs(project: Project) = signingConfigs {
    create("signingConfigRelease") {
        val keystorePropertiesFile = project.rootProject.file("keystore.properties")
        if (!keystorePropertiesFile.exists()) {
            System.err.println("Missing release.keystore.properties file for release signing")
        } else {
            val keystoreProperties = Properties().apply {
                load(FileInputStream(keystorePropertiesFile))
            }
            try {
                storeFile =
                    project.rootProject.file(keystoreProperties["storeFile"] as String)
                storePassword = keystoreProperties["storePassword"] as String
                keyAlias = keystoreProperties["keyAlias"] as String
                keyPassword = keystoreProperties["keyPassword"] as String
            } catch (e: Exception) {
                System.err.println("keystore.properties file is malformed")
            }
        }
    }
}

fun LibraryExtension.configureDefaultConfig() {
    defaultConfig.apply {
        minSdk = Configs.MinSdk
        targetSdk = Configs.TargetSdk
        versionCode = Configs.VersionCode
        versionName = Configs.VersionName
        testInstrumentationRunner = Configs.AndroidJunitRunner
    }
}

@Suppress("UnstableApiUsage")
fun LibraryExtension.enableCompose() {
    buildFeatures {
        compose = true
    }

    composeOptions.apply {
        kotlinCompilerExtensionVersion = Versions.ComposeCompiler
    }
}

fun AppExtension.configureDefaultConfig() {
    defaultConfig.apply {
        applicationId = Configs.Id

        minSdk = Configs.MinSdk
        targetSdk = Configs.TargetSdk
        versionCode = Configs.VersionCode
        versionName = Configs.VersionName
        testInstrumentationRunner = Configs.AndroidJunitRunner
    }
}
