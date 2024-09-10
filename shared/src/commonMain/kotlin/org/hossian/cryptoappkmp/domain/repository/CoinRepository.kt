package org.hossian.cryptoappkmp.domain.repository

import org.hossian.cryptoappkmp.domain.model.Coin
import org.hossian.cryptoappkmp.domain.model.CoinDetails

interface CoinRepository {

    suspend fun getCoins(): List<Coin>

    suspend fun getCoinById(coinId: String): CoinDetails
}