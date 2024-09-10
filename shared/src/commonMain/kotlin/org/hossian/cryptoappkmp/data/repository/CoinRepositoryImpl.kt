package org.hossian.cryptoappkmp.data.repository

import org.hossian.cryptoappkmp.data.remote.CoinPaprikaApi
import org.hossian.cryptoappkmp.data.remote.CoinPaprikaApiImpl
import org.hossian.cryptoappkmp.domain.model.Coin
import org.hossian.cryptoappkmp.domain.model.CoinDetails
import org.hossian.cryptoappkmp.domain.repository.CoinRepository

class CoinRepositoryImpl (
    private val api: CoinPaprikaApi = CoinPaprikaApiImpl()
) : CoinRepository {

    override suspend fun getCoins(): List<Coin> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetails {
        return api.getCoinById(coinId)
    }
}