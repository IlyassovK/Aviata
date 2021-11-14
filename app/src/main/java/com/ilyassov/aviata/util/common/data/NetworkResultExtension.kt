package com.ilyassov.aviata.util.common.data

import com.ilyassov.aviata.util.common.domain.ClientException
import com.ilyassov.aviata.util.common.domain.Result
import com.haroldadmin.cnradapter.NetworkResponse
import timber.log.Timber

inline fun <T : Any, R> NetworkResponse<T, ErrorResponse>.toResult(
    map: (response: T) -> R
): Result<R> {
    return when (this) {
        is NetworkResponse.Success -> Result.Success(map(this.body))
        is NetworkResponse.ServerError ->
            Result.Error(
                ClientException.ServerErrorException(
                    this.body?.errors?.firstOrNull()?.message ?: "Server error"
                )
            )
        is NetworkResponse.NetworkError ->
            Result.Error(ClientException.NoConnectException)
        is NetworkResponse.UnknownError -> {
            Timber.d("NetworkLayer::UnknownError: ${this.error}")
            Result.Error(ClientException.ServerUnavailableException)
        }
    }
}
