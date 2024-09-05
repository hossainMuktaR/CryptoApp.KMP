package org.hossian.cryptoappkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform