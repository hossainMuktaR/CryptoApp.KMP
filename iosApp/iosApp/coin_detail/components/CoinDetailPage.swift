//
//  CoinDetailPage.swift
//  CryptoApp.ios
//
//  Created by Hossain Muktar on 24/8/24.
//

import SwiftUI
import Shared

struct CoinDetailPage: View {
    let coin: CoinDetails
    var body: some View {
        ZStack {
            ScrollView {
                VStack(alignment: .leading, spacing: 15) {
                    HStack {
                        Text("\(coin.rank). \(coin.name) (\(coin.symbol))")
                            .font(.largeTitle)
                            .fontWeight(.bold)
                            .frame(maxWidth: .infinity, alignment: .leading)
                        
                        Text(coin.isActive ? "active" : "inactive")
                            .font(.headline)
                            .foregroundColor(coin.isActive ? .green : .red)
                            .italic()
                    }
                    
                    // Coin Description
                    Text(coin.description_)
                        .font(.body)
                    
                    // Tags
                    Text("Tags")
                        .font(.title2)
                        .fontWeight(.semibold)
                
                    ScrollView(.horizontal, showsIndicators: false) {
                        HStack{
                            ForEach(coin.tags, id: \.self) { tag in
                                CoinTagView(tag: tag.name)
                            }
                        }
                    }
                    
                    // Team Members
                    Text("Team members")
                        .font(.title2)
                        .fontWeight(.semibold)
                    
                    ForEach(coin.team, id: \.id) { teamMember in
                        VStack(alignment: .leading) {
                            TeamListItemView(teamMember: teamMember)
                            Divider()
                        }
                        .padding(.vertical, 5)
                    }
                }
                .padding(20)
            }
            
        }
    }
}


#Preview {
    CoinDetailPage(
        coin: CoinDetails(coinId: "btc-bitcoin", name: "BitCoin", description: "this is description of bitcoin currency", symbol: "B", rank: 1, isActive: true, tags: [Tag(coinCounter: 34, icoCounter: 234, id: "tag id", name: "tag name")], team: [TeamMember(id: "member id", name: "memeber name", position: "Member posistion")]))
}
