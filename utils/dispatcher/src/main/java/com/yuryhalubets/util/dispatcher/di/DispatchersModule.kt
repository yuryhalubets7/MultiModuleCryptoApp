/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.util.dispatcher.di

import com.yuryhalubets.util.dispatcher.DispatchersProvider
import com.yuryhalubets.util.dispatcher.DispatchersProviderImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DispatchersModule {

    @Binds
    @Singleton
    abstract fun provideDispatchersProvider(provider: DispatchersProviderImpl): DispatchersProvider

}