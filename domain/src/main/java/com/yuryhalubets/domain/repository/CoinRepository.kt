/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.domain.repository

import com.yuryhalubets.domain.models.Coin
import com.yuryhalubets.domain.models.CoinDetail

interface CoinRepository {

    suspend fun getCoins(): List<Coin>

    suspend fun getCoinById(coinId: String): CoinDetail
}