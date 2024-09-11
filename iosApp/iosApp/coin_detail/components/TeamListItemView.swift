//
//  TeamListItemView.swift
//  CryptoApp.ios
//
//  Created by Hossain Muktar on 24/8/24.
//

import SwiftUI
import Shared

// TeamListItemView (replicating TeamListItem component)
struct TeamListItemView: View {
    let teamMember: TeamMember
    
    var body: some View {
        VStack(alignment: .leading) {
            Text(teamMember.name)
                .font(.headline)
            Text(teamMember.position)
                .font(.subheadline)
                .foregroundColor(.gray)
        }
    }
}

#Preview {
    TeamListItemView(teamMember: TeamMember(id: "member id", name: "memeber name", position: "Member posistion"))
}
