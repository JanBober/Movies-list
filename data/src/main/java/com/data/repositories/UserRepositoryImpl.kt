package com.data.repositories

import com.data.client.api.UserApi
import com.domain.entities.model.Auth
import com.domain.entities.model.Token
import com.domain.repositories.UserRepository
import io.reactivex.Single

class UserRepositoryImpl(
    private val userApi: UserApi
) : UserRepository {

    override fun logIn(auth: Auth): Single<Token> {
        return userApi.apiUserLoginPost(auth)
    }

}
