/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.remote.repo

import com.yuryhalubets.domain.models.Coin
import com.yuryhalubets.domain.models.CoinDetail
import com.yuryhalubets.domain.repository.CoinRepository
import com.yuryhalubets.remote.api.CoinPaprikaApi
import com.yuryhalubets.remote.mapper.toDetailCoin
import com.yuryhalubets.remote.mapper.toDomainCoin
import javax.inject.Inject

/**
 * In ideal Clean Architecture world repository is domain implementation.
 * It should manipulate data sources that will be defined in proper modules (interfaces in domain too)
 * */
internal class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<Coin> {
        return api.getCoins().map { it.toDomainCoin() }
    }

    override suspend fun getCoinById(coinId: String): CoinDetail {
        return api.getCoinById(coinId).toDetailCoin()
    }
}