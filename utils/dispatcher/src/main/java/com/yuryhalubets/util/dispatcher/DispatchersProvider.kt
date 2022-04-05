/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.util.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Provide different dispatchers that should be used in real code.
 * Without using this provider it will be unable to unit test coroutines code.
 * */
interface DispatchersProvider {
    val main: CoroutineDispatcher
    val mainImmediate: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}