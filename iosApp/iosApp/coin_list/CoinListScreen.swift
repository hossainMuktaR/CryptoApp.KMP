//
//  CoinListScreen.swift
//  CryptoApp.ios
//
//  Created by Hossain Muktar on 7/8/24.
//

import SwiftUI

struct CoinListScreen: View {
    @StateObject var vm = CoinListViewModel()
    var body: some View {
        NavigationStack{
            ZStack{
                if vm.state.isLoading {
                    ProgressView()
                } else if let coins = vm.state.coins {
                    ScrollView{
                        LazyVStack(spacing: 0){
                            ForEach(coins, id: \.id) { coin in
                                NavigationLink(destination: CoinDetailScreen(coinId: coin.id)){
                                    ListItem(coin: coin)
                                }
                                Divider()
                                    .padding(.vertical, 8)
                            }
                        }
                    }
                    
                } else if let error = vm.state.error {
                    VStack{
                        Text("Something gone wrong")
                        Text("\(error)")
                    }
                }
            }
            .navigationTitle("Coin List")
            .navigationBarTitleDisplayMode(.inline)
        
        }.onAppear {
            vm.getCoins()
        }
    }
}

#Preview {
    CoinListScreen()
}
