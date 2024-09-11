package org.hossian.cryptoappkmp.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.hossian.cryptoappkmp.common.Resource
import org.hossian.cryptoappkmp.data.repository.CoinRepositoryImpl
import org.hossian.cryptoappkmp.domain.model.Coin
import org.hossian.cryptoappkmp.domain.repository.CoinRepository

class GetCoinsUseCase(
    private val repository: CoinRepository = CoinRepositoryImpl()
) {
    fun execute(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().subList(0, 100)
            println("the size of response list are : ${coins.size}")
            emit(Resource.Success(coins))
        } catch(e: Exception) {
            emit(Resource.Error("something wrong when api are called"))
        }
    }
}