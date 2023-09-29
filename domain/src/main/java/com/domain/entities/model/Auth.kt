package com.domain.entities.model

import com.google.gson.annotations.SerializedName

data class Auth(
    @SerializedName("username") var username: String? = null,
    @SerializedName("password") var password: String? = null,
    @SerializedName("request_token") var requestToken: String? = null
)
