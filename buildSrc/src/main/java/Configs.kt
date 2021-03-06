object Configs {

    private const val versionMajor = 1

    private const val versionMinor = 0

    private const val versionPatch = 0

    private fun generateVersionCode(): Int {
        return versionMajor * 10000 + versionMinor * 100 + versionPatch
    }

    private fun generateVersionName(): String {
        return "$versionMajor.$versionMinor.${versionPatch}"
    }

    const val Id = "com.yuryhalubets.composecryptoapp"

    val VersionCode = generateVersionCode()

    val VersionName = generateVersionName()

    const val MinSdk = 23

    const val TargetSdk = 31

    const val CompileSdk = 31

    const val AndroidJunitRunner = "androidx.test.runner.AndroidJUnitRunner"

    val FreeCompilerArgs = listOf(
        "-Xopt-in=kotlin.RequiresOptIn",
        "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
        "-Xopt-in=kotlinx.coroutines.InternalCoroutinesApi",
        "-Xopt-in=kotlinx.coroutines.FlowPreview",
        "-Xopt-in=kotlin.Experimental",
        "-Xjvm-default=all"
    )

    object Release {
        const val BASE_URL = "https://api.coinpaprika.com/"
    }

    object Debug {
        const val BASE_URL = "https://api.coinpaprika.com/"
    }
}
