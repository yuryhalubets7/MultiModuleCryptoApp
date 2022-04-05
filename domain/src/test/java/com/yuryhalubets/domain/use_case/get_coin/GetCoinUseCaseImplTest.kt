/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.domain.use_case.get_coin

import com.yuryhalubets.core.domain.Resource
import com.yuryhalubets.domain.models.CoinDetail
import com.yuryhalubets.domain.repository.CoinRepository
import com.yuryhalubets.utils.tests.rule.TestCoroutineRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class GetCoinUseCaseImplTest {

    @Rule
    @JvmField
    val testCoroutineRule = TestCoroutineRule()

    @MockK
    private lateinit var repository: CoinRepository

    private lateinit var objectUnderTest: GetCoinUseCaseImpl

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        objectUnderTest = GetCoinUseCaseImpl(repository)
    }

     @Test
     fun `invoke - getCoinById failed - loading and failure states received`() = runTest {
         coEvery { repository.getCoinById(any()) } throws RuntimeException("Test exception")

         val list = objectUnderTest.invoke("testId").toList()

         assertEquals(2, list.size)
         assertTrue(list.first() is Resource.Loading)
         assertTrue(list.last() is Resource.Error)
     }

    @Test
    fun `invoke - getCoinById succeed - loading and success states received`() = runTest {
        val coinDetail = mockk<CoinDetail>(relaxed = true)
        coEvery { repository.getCoinById(any()) } returns coinDetail

        val list = objectUnderTest.invoke("testId").toList()

        assertEquals(2, list.size)
        assertTrue(list.first() is Resource.Loading)
        val lastResult = list.last()
        assertTrue(lastResult is Resource.Success && lastResult.data == coinDetail)
    }
}