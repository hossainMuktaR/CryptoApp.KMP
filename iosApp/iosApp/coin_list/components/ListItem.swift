//
//  ListItem.swift
//  CryptoApp.ios
//
//  Created by Hossain Muktar on 7/8/24.
//

import SwiftUI
import Shared

struct ListItem: View {
    var coin: Coin
    var body: some View {
        HStack(alignment: .center) {
            Text("\(coin.rank). \(coin.name) (\(coin.symbol))")
            Spacer()
            Text(coin.isActive ? "active" : "inactive")
        }
        .padding(.horizontal)
        .frame(maxWidth: /*@START_MENU_TOKEN@*/.infinity/*@END_MENU_TOKEN@*/)
    
    
    }
}

#Preview {
    ListItem(coin: Coin(id: "hi", isActive: true, name: "Bitcoin", rank: 1, symbol: "BTC")
)
}
