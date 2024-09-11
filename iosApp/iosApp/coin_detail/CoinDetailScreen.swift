//
//  CoinDetailScreen.swift
//  CryptoApp.ios
//
//  Created by Hossain Muktar on 23/8/24.
//

import SwiftUI

struct CoinDetailScreen: View {
    private let coinId: String
    @StateObject private var vm: CoinDetailViewModel
    
    init(coinId: String) {
        self.coinId = coinId
        _vm = StateObject(wrappedValue: CoinDetailViewModel(coinId: coinId))
    }
    
    var body: some View {
        ZStack{
            if vm.state.isLoading {
                ProgressView()
            } else if let coin = vm.state.coin {
                CoinDetailPage(coin: coin)
                    .navigationTitle(coin.name)
                    .navigationBarTitleDisplayMode(.inline)
            } else if vm.state.error != nil {
                VStack{
                    Text("Something gone wrong")
                    Text("\(String(describing: vm.state.error))")
                }
            }
        }.onAppear {
            vm.getCoinById(coinId: coinId)
        }
    }
}


