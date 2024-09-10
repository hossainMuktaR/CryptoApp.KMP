package org.hossian.cryptoappkmp

sealed class Screen(val route: String) {
    data object CoinListScreen: Screen("coin_list_screen")
    data object CoinDetailScreen: Screen("coin_detail_screen")
}

object Constants {
    const val PARAM_COIN_ID = "coinId"
}