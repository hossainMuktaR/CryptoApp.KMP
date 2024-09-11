package org.hossian.cryptoappkmp.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.hossian.cryptoappkmp.common.Resource
import org.hossian.cryptoappkmp.domain.usecases.GetCoinsUseCase

class CoinListViewModel(
    private val getCoinsUseCase: GetCoinsUseCase = GetCoinsUseCase()
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        println("viewmodel: get Coins called")
        viewModelScope.launch {
            getCoinsUseCase.execute().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = CoinListState(coins = result.data ?: emptyList())
                    }

                    is Resource.Error -> {
                        _state.value = CoinListState(
                            error = result.message ?: "An unexpected error occured"
                        )
                    }

                    is Resource.Loading -> {
                        _state.value = CoinListState(isLoading = true)
                    }
                }
            }
        }
    }
}