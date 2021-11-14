package com.ilyassov.aviata.util.common.data

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("code")
    val code: Int,
    @SerializedName("errors")
    val errors: List<Error>
)

data class Error(
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String
)
