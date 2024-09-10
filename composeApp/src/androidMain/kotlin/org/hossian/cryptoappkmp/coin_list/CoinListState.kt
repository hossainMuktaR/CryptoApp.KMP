package org.hossian.cryptoappkmp.coin_list

import org.hossian.cryptoappkmp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)