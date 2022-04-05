/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.domain.use_case.get_coins

import com.yuryhalubets.core.domain.Resource
import com.yuryhalubets.domain.models.Coin
import com.yuryhalubets.domain.repository.CoinRepository
import com.yuryhalubets.utils.tests.rule.TestCoroutineRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class GetCoinsUseCaseImplTest {

    @Rule
    @JvmField
    val testCoroutineRule = TestCoroutineRule()

    @MockK
    private lateinit var repository: CoinRepository

    private lateinit var objectUnderTest: GetCoinsUseCaseImpl

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        objectUnderTest = GetCoinsUseCaseImpl(repository)
    }

    @Test
    fun `invoke - getCoins failed - loading and failure states received`() = runTest {
        coEvery { repository.getCoins() } throws RuntimeException("Test exception")

        val list = objectUnderTest.invoke().toList()

        TestCase.assertEquals(2, list.size)
        TestCase.assertTrue(list.first() is Resource.Loading)
        TestCase.assertTrue(list.last() is Resource.Error)
    }

    @Test
    fun `invoke - getCoins succeed - loading and success states received`() = runTest {
        val coins = mockk<List<Coin>>(relaxed = true)
        coEvery { repository.getCoins() } returns coins

        val list = objectUnderTest.invoke().toList()

        TestCase.assertEquals(2, list.size)
        TestCase.assertTrue(list.first() is Resource.Loading)
        val lastResult = list.last()
        TestCase.assertTrue(lastResult is Resource.Success && lastResult.data == coins)
    }
}