package com.ilyassov.aviata.util.common.domain

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: ClientException) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$error]"
        }
    }
}

/**
 * `true` if [Result] is of type [Result.Success] & holds non-null [Result.Success.data].
 */
val Result<*>.succeeded
    get() = this is Result.Success && data != null

fun <T> Result<T>.successOr(fallback: T): T {
    return (this as? Result.Success<T>)?.data ?: fallback
}

inline fun <T> Result<T>.onSuccess(callback: (data: T) -> Unit): Result<T> {
    (this as? Result.Success<T>)?.data?.let(callback)
    return this
}

inline fun <T> Result<T>.onError(callback: (error: ClientException) -> Unit): Result<T> {
    (this as? Result.Error)?.error?.let(callback)
    return this
}
