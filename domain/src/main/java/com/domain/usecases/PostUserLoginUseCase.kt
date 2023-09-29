package com.domain.usecases

import com.domain.entities.model.Auth
import com.domain.entities.model.Token
import com.domain.repositories.UserRepository
import io.reactivex.Single

class PostUserLoginUseCase(private val userRepository: UserRepository) {

    fun login(auth: Auth): Single<Token> {
        return userRepository.logIn(auth)
    }
}
