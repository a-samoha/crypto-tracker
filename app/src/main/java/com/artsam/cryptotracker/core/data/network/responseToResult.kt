package com.artsam.cryptotracker.core.data.network

import com.artsam.cryptotracker.core.domain.util.NetworkError
import com.artsam.cryptotracker.core.domain.util.Result
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse

/**
 * "inline" is needed together with "reified"
 * "reified" is needed in order to get the type info of the generic T
 * otherwise fun .body won't know which specific type we want to parse it into
 * because the generic T is only available at compile time NOT on runtime
 */
suspend inline fun <reified T> responseToResult(
    response: HttpResponse
): Result<T, NetworkError> {
    return when(response.status.value) {
        // Successful request
        in 200..299 -> {
            try {
                Result.Success(response.body<T>())
            } catch(e: NoTransformationFoundException) {
                Result.Error(NetworkError.SERIALIZATION)
            }
        }
        408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
        429 -> Result.Error(NetworkError.TOO_MANY_REQUESTS)
        in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
        else -> Result.Error(NetworkError.UNKNOWN)
    }
}