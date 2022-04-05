/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.remote.mapper

import com.yuryhalubets.remote.api.dto.CoinDto
import com.yuryhalubets.domain.models.Coin as DomainCoin

internal fun CoinDto.toDomainCoin(): DomainCoin {
    return DomainCoin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}