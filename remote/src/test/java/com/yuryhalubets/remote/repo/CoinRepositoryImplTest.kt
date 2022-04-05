/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.remote.repo


import com.yuryhalubets.remote.api.CoinPaprikaApi
import com.yuryhalubets.remote.api.dto.CoinDetailDto
import com.yuryhalubets.remote.api.dto.CoinDto
import com.yuryhalubets.remote.mapper.toDetailCoin
import com.yuryhalubets.remote.mapper.toDomainCoin
import com.yuryhalubets.utils.tests.rule.TestCoroutineRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class CoinRepositoryImplTest {

    @Rule
    @JvmField
    val testCoroutineRule = TestCoroutineRule()

    @MockK
    lateinit var api: CoinPaprikaApi

    private lateinit var objectUnderTest: CoinRepositoryImpl

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        objectUnderTest = CoinRepositoryImpl(api)
    }

    @Test(expected = Throwable::class)
    fun `getCoins - request failed - exception is thrown`() = runTest {
        coEvery { api.getCoins() } throws RuntimeException("message")

        objectUnderTest.getCoins()
    }

    @Test
    fun `getCoins - request succeed - proper list returned`() = runTest {
        val model: CoinDto = mockk(relaxed = true)
        coEvery { api.getCoins() } returns listOf(model)

        assertEquals(listOf(model.toDomainCoin()), objectUnderTest.getCoins())
    }

    @Test(expected = Throwable::class)
    fun `getCoinById - request failed - exception is thrown`() = runTest {
        coEvery { api.getCoinById(any()) } throws RuntimeException("message")

        objectUnderTest.getCoinById("coinId")
    }

    @Test
    fun `getCoinById - request succeed - proper list returned`() = runTest {
        val model: CoinDetailDto = mockk(relaxed = true)
        coEvery { api.getCoinById(any()) } returns model

        assertEquals(model.toDetailCoin(), objectUnderTest.getCoinById("coinId"))
    }
}