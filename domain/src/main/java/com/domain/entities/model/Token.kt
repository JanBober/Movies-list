package com.domain.entities.model

import com.google.gson.annotations.SerializedName

data class Token(
    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("expires_at") var expiresAt: String? = null,
    @SerializedName("request_token") var requestToken: String? = null
)
