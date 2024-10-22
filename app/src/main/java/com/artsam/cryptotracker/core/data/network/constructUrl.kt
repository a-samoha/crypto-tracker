package com.artsam.cryptotracker.core.data.network

import com.artsam.cryptotracker.BuildConfig

/**
 * @param url can be
 * - "api.coincap.io/v2/"
 * - "/assets"
 */
fun constructUrl(url: String): String {
    return when {
        url.contains(BuildConfig.BASE_URL) -> url
        url.startsWith("/") -> BuildConfig.BASE_URL + url.drop(1) // drop the symbol "/"
        else -> BuildConfig.BASE_URL + url
    }
}