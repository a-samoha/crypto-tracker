package com.artsam.cryptotracker.crypto.presentation.coin_list

import com.artsam.cryptotracker.crypto.presentation.models.CoinUi

sealed interface CoinListAction {

    data class OnCoinClick(val coinUi: CoinUi) : CoinListAction

    data object OnSwipeRefresh : CoinListAction
}