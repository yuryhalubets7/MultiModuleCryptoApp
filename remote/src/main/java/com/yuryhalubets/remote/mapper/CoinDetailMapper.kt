/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.remote.mapper

import com.yuryhalubets.remote.api.dto.CoinDetailDto
import com.yuryhalubets.domain.models.CoinDetail as DomainCoinDetail

internal fun CoinDetailDto.toDetailCoin(): DomainCoinDetail {
    return DomainCoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team = team.map { it.name }
    )
}

