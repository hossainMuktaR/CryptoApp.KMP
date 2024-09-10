package org.hossian.cryptoappkmp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coin(
    val id: String,
    @SerialName("is_active")
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)