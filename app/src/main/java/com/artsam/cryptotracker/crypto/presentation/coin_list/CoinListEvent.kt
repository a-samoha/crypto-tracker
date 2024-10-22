package com.artsam.cryptotracker.crypto.presentation.coin_list

import com.artsam.cryptotracker.core.domain.util.NetworkError

sealed interface CoinListEvent {

    data class Error(val error: NetworkError): CoinListEvent
}