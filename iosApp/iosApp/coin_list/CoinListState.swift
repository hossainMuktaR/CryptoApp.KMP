//
//  CoinListState.swift
//  CryptoApp.ios
//
//  Created by Hossain Muktar on 7/8/24.
//

import Foundation
import Shared

struct CoinListState {
    var isLoading: Bool = true
    var coins: [Coin]? = nil
    var error: String? = nil
}
