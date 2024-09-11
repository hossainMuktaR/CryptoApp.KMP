//
//  CoinDetailViewModel.swift
//  CryptoApp.ios
//
//  Created by Hossain Muktar on 24/8/24.
//

import Foundation
import Shared

@MainActor
class CoinDetailViewModel: ObservableObject {
    private let getCoinByIdUseCase: GetCoinUseCase
    private let coinId: String
    @Published var state = CoinDetailState()
    
    init(coinId: String) {
        self.getCoinByIdUseCase = GetCoinUseCase(repository: CoinRepositoryImpl(api: CoinPaprikaApiImpl()))
        self.coinId = coinId
    }
    
    func getCoinById(coinId: String) {
        print("vm: getCoinById Called")
        Task{
            state = CoinDetailState(isLoading: true)
            for await phrase in self.getCoinByIdUseCase.execute(coinId: self.coinId) {
                if let data = phrase.data {
                    state = CoinDetailState( isLoading: false, coin: data)
                }
            }
        }
    }
}
