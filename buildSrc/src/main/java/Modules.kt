object Modules {
    const val Remote = ":remote"
    const val Domain = ":domain"
    const val DI = ":di"
    const val Components = ":components"
    const val Navigation = ":navigation"

    object Util {
        private const val Util = ":utils"
        const val Dispatcher = "$Util:dispatcher"
        const val Tests = "$Util:tests"
    }

    object Core {
        private const val Core = ":core"
        const val Domain = "$Core:domain"
        const val Ui = "$Core:ui"
        const val DI = "$Core:di"
    }

    object Feature {
        private const val Feature = ":feature"
        object Coin {
            private const val Coin = ":coin"

            const val Detail = "$Feature$Coin:detail"
            const val List = "$Feature$Coin:list"
        }
    }

}