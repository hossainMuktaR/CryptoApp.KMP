//
//  CoinDetailState.swift
//  CryptoApp.ios
//
//  Created by Hossain Muktar on 23/8/24.
//

import Foundation
import Shared

struct CoinDetailState {
    var isLoading: Bool = true
    var coin: CoinDetails? = nil
    var error: String? = nil
}
