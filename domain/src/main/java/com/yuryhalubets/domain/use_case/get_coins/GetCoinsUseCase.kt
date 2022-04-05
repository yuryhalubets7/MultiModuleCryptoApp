/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.domain.use_case.get_coins

import com.yuryhalubets.core.domain.Resource
import com.yuryhalubets.domain.models.Coin
import kotlinx.coroutines.flow.Flow

interface GetCoinsUseCase {
    operator fun invoke(): Flow<Resource<List<Coin>>>
}