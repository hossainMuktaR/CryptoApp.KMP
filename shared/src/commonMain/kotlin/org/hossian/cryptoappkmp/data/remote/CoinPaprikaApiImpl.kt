package org.hossian.cryptoappkmp.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.Url
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.hossian.cryptoappkmp.common.CoinPaprikaRoutes
import org.hossian.cryptoappkmp.domain.model.Coin
import org.hossian.cryptoappkmp.domain.model.CoinDetails

class CoinPaprikaApiImpl: CoinPaprikaApi {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }
    override suspend fun getCoins(): List<Coin> {
        return try {
            val response = client.get(url = Url(CoinPaprikaRoutes.GET_COINS)) {

            }
            println("the response: ${response.bodyAsText()}")
            response.body()
        }catch(e: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }

    override suspend fun getCoinById(coinId: String): CoinDetails {
        return client.get { CoinPaprikaRoutes.GET_COINS + "/${coinId}" }.body()
    }

}