/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.domain.di

import com.yuryhalubets.domain.use_case.get_coin.GetCoinUseCase
import com.yuryhalubets.domain.use_case.get_coin.GetCoinUseCaseImpl
import com.yuryhalubets.domain.use_case.get_coins.GetCoinsUseCase
import com.yuryhalubets.domain.use_case.get_coins.GetCoinsUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DomainModule {

    @Binds
    internal abstract fun bindGetCoins(getCoinsUseCaseImpl: GetCoinsUseCaseImpl): GetCoinsUseCase

    @Binds
    internal abstract fun bindGetCoin(getCoinUseCase: GetCoinUseCaseImpl): GetCoinUseCase

}
