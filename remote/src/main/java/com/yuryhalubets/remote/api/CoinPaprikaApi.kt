/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.remote.api

import com.yuryhalubets.remote.api.dto.CoinDetailDto
import com.yuryhalubets.remote.api.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

internal interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}