/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.feature.coin.list.vm

import android.app.Application
import android.content.res.Resources
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.yuryhalubets.core.domain.Resource
import com.yuryhalubets.domain.use_case.get_coins.GetCoinsUseCase
import com.yuryhalubets.feature.R
import com.yuryhalubets.util.dispatcher.DispatchersProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    application: Application,
    private val getCoinsUseCase: GetCoinsUseCase,
    private val dispatchersProvider: DispatchersProvider,
    private val resources: Resources,
) : AndroidViewModel(application) {

    private val _state: MutableState<CoinsState> = mutableStateOf(CoinsState.Loading)
    val state: State<CoinsState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase()
            .flowOn(dispatchersProvider.io)
            .onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = CoinsState.Success(data = result.data.orEmpty())
                    }
                    is Resource.Error -> {
                        _state.value = CoinsState.Failure(
                            errorMessage = result.message
                                ?: resources.getString(R.string.unexpected_error)
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = CoinsState.Loading
                    }
                }
            }
            .launchIn(viewModelScope)
    }
}