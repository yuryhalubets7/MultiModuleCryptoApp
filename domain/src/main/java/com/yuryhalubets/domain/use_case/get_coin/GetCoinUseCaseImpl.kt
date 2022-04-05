/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.domain.use_case.get_coin

import com.yuryhalubets.core.domain.Resource
import com.yuryhalubets.domain.models.CoinDetail
import com.yuryhalubets.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

internal class GetCoinUseCaseImpl @Inject constructor(
    private val repository: CoinRepository
) : GetCoinUseCase {
    override operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId)
            emit(Resource.Success(coin))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }
    }
}