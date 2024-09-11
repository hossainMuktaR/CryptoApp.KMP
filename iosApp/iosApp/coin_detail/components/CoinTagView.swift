//
//  CoinTagView.swift
//  CryptoApp.ios
//
//  Created by Hossain Muktar on 24/8/24.
//

import SwiftUI

// CoinTagView (replicating CoinTag component)
struct CoinTagView: View {
    let tag: String
    
    var body: some View {
        Text(tag)
            .padding(.horizontal, 8)
            .padding(.vertical, 4)
            .background(Color.blue.opacity(0.2))
            .cornerRadius(8)
    }
}

#Preview {
    CoinTagView(tag: "HI")
}
