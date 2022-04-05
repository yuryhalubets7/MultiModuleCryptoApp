/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.domain.models

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<String>
)
