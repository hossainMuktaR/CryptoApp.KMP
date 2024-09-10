package org.hossian.cryptoappkmp.coin_details

import org.hossian.cryptoappkmp.domain.model.CoinDetails

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetails? = null,
    val error: String = ""
)