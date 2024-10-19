package com.artsam.cryptotracker.crypto.presentation.coin_list

import androidx.compose.runtime.Immutable
import com.artsam.cryptotracker.crypto.presentation.models.CoinUi

@Immutable // to tell compose framework not to recompose more often then necessary (only when tha data change)
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinUi> = emptyList(), // otherwise use Kotlinx Immutable collections (additional dependency)
    val selectedCoin: CoinUi? = null,
)
