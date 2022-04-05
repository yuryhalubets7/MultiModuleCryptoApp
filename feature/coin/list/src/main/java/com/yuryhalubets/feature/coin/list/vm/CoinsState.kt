/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.feature.coin.list.vm

import com.yuryhalubets.domain.models.Coin

sealed class CoinsState {

    object Loading : CoinsState()

    data class Success(val data: List<Coin>) : CoinsState()

    data class Failure(val errorMessage: String) : CoinsState()
}