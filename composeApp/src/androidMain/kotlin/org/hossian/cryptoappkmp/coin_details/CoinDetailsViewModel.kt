package org.hossian.cryptoappkmp.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.hossian.cryptoappkmp.Constants
import org.hossian.cryptoappkmp.common.Resource
import org.hossian.cryptoappkmp.domain.UseCases.GetCoinUseCase

class CoinDetailsViewModel (
    private val getCoinUseCase: GetCoinUseCase = GetCoinUseCase(),
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        viewModelScope.launch {
            getCoinUseCase.execute(coinId).collect { result ->
                when (result) {
                    is Resource.Success -> {
                        _state.value = CoinDetailState(coin = result.data)
                    }

                    is Resource.Error -> {
                        _state.value = CoinDetailState(
                            error = result.message ?: "An unexpected error occured"
                        )
                    }

                    is Resource.Loading -> {
                        _state.value = CoinDetailState(isLoading = true)
                    }
                }
            }
        }
    }
}