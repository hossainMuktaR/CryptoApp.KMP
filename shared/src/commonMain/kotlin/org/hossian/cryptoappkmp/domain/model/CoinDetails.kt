package org.hossian.cryptoappkmp.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinDetails(
    @SerialName("id")
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    @SerialName("is_active")
    val isActive: Boolean,
    val tags: List<Tag>,
    val team: List<TeamMember>
)