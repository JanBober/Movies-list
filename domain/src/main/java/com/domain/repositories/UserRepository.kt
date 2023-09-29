package com.domain.repositories

import com.domain.entities.model.Auth
import com.domain.entities.model.Token
import io.reactivex.Single

interface UserRepository {

    fun logIn(auth: Auth): Single<Token>
}
