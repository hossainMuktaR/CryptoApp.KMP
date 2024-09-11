package org.hossian.cryptoappkmp


import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.hossian.cryptoappkmp.coin_details.CoinDetailsScreen
import org.hossian.cryptoappkmp.coin_details.CoinDetailsViewModel
import org.hossian.cryptoappkmp.coin_details.CoinDetailsViewModelFactory
import org.hossian.cryptoappkmp.coin_list.CoinListScreen
import org.hossian.cryptoappkmp.coin_list.CoinListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Screen.CoinListScreen.route
        ) {
            composable(
                route = Screen.CoinListScreen.route
            ) {
                val vm: CoinListViewModel = viewModel()
                CoinListScreen(navController, vm)
            }
            composable(
                route = Screen.CoinDetailScreen.route + "/{coinId}"
            ) {
                val coinId = it.arguments?.getString("coinId")
                val vm: CoinDetailsViewModel = viewModel(
                    factory = CoinDetailsViewModelFactory(
                        coinId = coinId ?: ""
                    )
                )
                CoinDetailsScreen(vm)
            }
        }
    }
}