package com.ilyassov.aviata.util.common.domain

sealed class ClientException {
    object NoConnectException : ClientException()
    object ServerUnavailableException : ClientException()
    class ServerErrorException(val message: String? = null) : ClientException()
    class ErrorInInitializationWallets(val message: String? = null) : ClientException()
}
