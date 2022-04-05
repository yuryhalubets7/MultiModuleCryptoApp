/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.feature.coin.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.yuryhalubets.feature.coin.list.components.CoinListItem
import com.yuryhalubets.feature.coin.list.vm.CoinsState
import com.yuryhalubets.components.CenterCircularProgressBar
import com.yuryhalubets.components.ErrorText
import androidx.compose.foundation.lazy.items

@Composable
fun CoinListScreen(
    state: CoinsState,
    onSelectItem: (String) -> Unit
) {
    when (state) {
        is CoinsState.Loading -> CenterCircularProgressBar()
        is CoinsState.Failure -> ErrorText(errorMessage = state.errorMessage)
        is CoinsState.Success -> state.data.let { coins ->
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(coins) { coin ->
                        CoinListItem(
                            coin = coin,
                            onItemClick = { item ->
                                onSelectItem(item.id)
                            }
                        )
                    }
                }

            }
        }
    }
}
