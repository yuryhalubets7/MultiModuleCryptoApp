package com.yuryhalubets.composecryptoapp.di

import com.yuryhalubets.composecryptoapp.BuildConfig
import com.yuryhalubets.core.di.qualifier.PaprikaApiUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BuildConfigModule {

    @Provides
    @PaprikaApiUrl
    fun providePaprikaApiUrl(): String = BuildConfig.BASE_URL

}