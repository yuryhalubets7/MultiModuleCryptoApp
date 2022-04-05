/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yuryhalubets.feature.coin.detail.CoinDetailScreen
import com.yuryhalubets.feature.coin.detail.vm.CoinDetailViewModel
import com.yuryhalubets.feature.coin.list.CoinListScreen
import com.yuryhalubets.feature.coin.list.vm.CoinListViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.CoinListScreen.route
    ) {
        composable(
            route = Screen.CoinListScreen.route
        ) {
            val viewModel: CoinListViewModel = hiltViewModel()
            CoinListScreen(
                state = viewModel.state.value,
                onSelectItem = { coinId ->
                    navController.navigate(Screen.CoinDetailScreen.route + "/${coinId}")
                }
            )
        }
        composable(
            route = Screen.CoinDetailScreen.route + "/{coinId}"
        ) {
            val viewModel: CoinDetailViewModel = hiltViewModel()
            CoinDetailScreen(
                state = viewModel.state.value
            )
        }
    }
}