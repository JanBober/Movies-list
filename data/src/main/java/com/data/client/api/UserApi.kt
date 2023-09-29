package com.data.client.api

import com.domain.entities.model.Auth
import com.domain.entities.model.Token
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("authentication/token/validate_with_login")
    fun apiUserLoginPost(
        @Body auth: Auth?
    ): Single<Token>
}
