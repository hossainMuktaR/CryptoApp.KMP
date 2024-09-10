package org.hossian.cryptoappkmp.data.remote

import org.hossian.cryptoappkmp.domain.model.Coin
import org.hossian.cryptoappkmp.domain.model.CoinDetails

interface CoinPaprikaApi {

    suspend fun getCoins(): List<Coin>

    suspend fun getCoinById(
        coinId: String
    ): CoinDetails
}