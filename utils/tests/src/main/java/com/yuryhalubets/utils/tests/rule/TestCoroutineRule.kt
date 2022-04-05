/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.utils.tests.rule

import com.yuryhalubets.util.dispatcher.DispatchersProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

/**
 * Test rule that change main dispatcher to test one.
 * Provides [dispatchersProvider] with mocked test dispatchers that should be used in testing components
 * */
@ExperimentalCoroutinesApi
class TestCoroutineRule(
    private val testScheduler: TestCoroutineScheduler = TestCoroutineScheduler(),
    private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher(testScheduler)
) : TestWatcher() {

    val dispatchersProvider: DispatchersProvider = object : DispatchersProvider {
        override val main: CoroutineDispatcher
            get() = testDispatcher
        override val mainImmediate: CoroutineDispatcher
            get() = testDispatcher
        override val io: CoroutineDispatcher
            get() = testDispatcher
        override val default: CoroutineDispatcher
            get() = testDispatcher
        override val unconfined: CoroutineDispatcher
            get() = testDispatcher
    }

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}