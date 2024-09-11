//
//  CoinListViewModel.swift
//  CryptoApp.ios
//
//  Created by Hossain Muktar on 7/8/24.
//

import Foundation
import Shared

@MainActor
class CoinListViewModel: ObservableObject{
    private let getCoinUseCase: GetCoinsUseCase
    
    @Published var state = CoinListState()
    
    init() {
        self.getCoinUseCase = GetCoinsUseCase(repository: CoinRepositoryImpl(api: CoinPaprikaApiImpl()))
    }
    
    func getCoins() {
        print("vm: getCoins Called")
        Task{
            for await phrase in self.getCoinUseCase.execute() {
                if let data = phrase.data as? [Coin]? {
                    state = CoinListState(isLoading: false, coins: data)
                }
            }
        }
    }
    
}
