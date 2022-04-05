/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.domain.use_case.get_coin

import com.yuryhalubets.core.domain.Resource
import com.yuryhalubets.domain.models.CoinDetail
import kotlinx.coroutines.flow.Flow

interface GetCoinUseCase {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>>
}