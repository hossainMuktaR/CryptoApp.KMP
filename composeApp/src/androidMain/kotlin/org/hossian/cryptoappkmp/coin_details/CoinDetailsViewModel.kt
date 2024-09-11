package org.hossian.cryptoappkmp.coin_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.hossian.cryptoappkmp.common.Resource
import org.hossian.cryptoappkmp.domain.usecases.GetCoinUseCase

class CoinDetailsViewModel (
    private val getCoinUseCase: GetCoinUseCase = GetCoinUseCase(),
    coinId: String
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
       coinId.let { coinId ->
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

class CoinDetailsViewModelFactory(
    private val coinId: String
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CoinDetailsViewModel::class.java)) {
            return CoinDetailsViewModel(coinId = coinId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}