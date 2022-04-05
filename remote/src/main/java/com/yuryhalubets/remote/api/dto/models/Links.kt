/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.remote.api.dto.models


import com.google.gson.annotations.SerializedName

/**
 * Try to keep all only module related things internal
 * */
data class Links(
    val explorer: List<String>,
    val facebook: List<String>,
    val reddit: List<String>,
    // I would suggest to use @SerializedName for all remote model parameters. It will help you to not rename JSON name when you do refactor / changes
    @SerializedName("source_code")
    val sourceCode: List<String>,
    val website: List<String>,
    val youtube: List<String>
)