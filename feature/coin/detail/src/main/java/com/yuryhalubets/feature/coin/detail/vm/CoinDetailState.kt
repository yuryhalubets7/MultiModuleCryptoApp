/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.feature.coin.detail.vm

import com.yuryhalubets.domain.models.CoinDetail

sealed class CoinDetailState {

    object Loading : CoinDetailState()

    data class Success(val data: CoinDetail) : CoinDetailState()

    data class Failure(val errorMessage: String) : CoinDetailState()
}