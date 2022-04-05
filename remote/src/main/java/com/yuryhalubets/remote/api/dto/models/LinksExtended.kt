/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.remote.api.dto.models


data class LinksExtended(
    val stats: Stats,
    val type: String,
    val url: String
)