/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.remote.di

import com.yuryhalubets.core.di.qualifier.PaprikaApiUrl
import com.yuryhalubets.domain.repository.CoinRepository
import com.yuryhalubets.remote.BuildConfig
import com.yuryhalubets.remote.api.CoinPaprikaApi
import com.yuryhalubets.remote.repo.CoinRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object RemoteModule {

    @Provides
    @Singleton
    internal fun providePaprikaApi(
        @PaprikaApiUrl apiUrl: String,
    ): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    internal fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}