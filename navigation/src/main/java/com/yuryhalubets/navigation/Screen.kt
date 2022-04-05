/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.navigation

sealed class Screen(val route: String) {
    object CoinListScreen : Screen(COIN_LIST_SCREEN)
    object CoinDetailScreen : Screen(COIN_DETAIL_SCREEN)

    private companion object {
        const val COIN_LIST_SCREEN = "coin_list_screen"
        const val COIN_DETAIL_SCREEN = "coin_detail_screen"
    }
}
