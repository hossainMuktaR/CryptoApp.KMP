package org.hossian.cryptoappkmp.domain.usecases

import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.hossian.cryptoappkmp.common.Resource
import org.hossian.cryptoappkmp.data.repository.CoinRepositoryImpl
import org.hossian.cryptoappkmp.domain.model.CoinDetails
import org.hossian.cryptoappkmp.domain.repository.CoinRepository

class GetCoinUseCase(
    private val repository: CoinRepository = CoinRepositoryImpl()
) {
    fun execute(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId)
            emit(Resource.Success(coin))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}