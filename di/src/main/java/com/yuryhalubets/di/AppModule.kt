/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.di

import android.content.Context
import android.content.res.Resources
import com.yuryhalubets.domain.di.DomainModule
import com.yuryhalubets.remote.di.RemoteModule
import com.yuryhalubets.util.dispatcher.di.DispatchersModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module(includes = [DomainModule::class, RemoteModule::class, DispatchersModule::class])
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideResources(@ApplicationContext context: Context): Resources = context.resources

}