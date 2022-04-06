/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.feature.coin.detail.vm

import android.content.res.Resources
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yuryhalubets.core.domain.Resource
import com.yuryhalubets.domain.use_case.get_coin.GetCoinUseCase
import com.yuryhalubets.feature.coin.detail.R
import com.yuryhalubets.util.dispatcher.DispatchersProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    private val dispatchersProvider: DispatchersProvider,
    private val resources: Resources,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state: MutableState<CoinDetailState> = mutableStateOf(CoinDetailState.Loading)
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(argCoinId)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId)
            .flowOn(dispatchersProvider.io)
            .onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        val data = result.data
                        if (data == null) {
                            _state.value = CoinDetailState.Failure(
                                errorMessage = resources.getString(R.string.data_is_empty)
                            )
                        } else {
                            _state.value = CoinDetailState.Success(data = data)
                        }
                    }
                    is Resource.Error -> {
                        _state.value = CoinDetailState.Failure(
                            errorMessage = result.message
                                ?: resources.getString(R.string.unexpected_error)
                        )
                    }
                    is Resource.Loading -> {
                        _state.value = CoinDetailState.Loading
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    private companion object {
        const val argCoinId = "coinId"
    }
}