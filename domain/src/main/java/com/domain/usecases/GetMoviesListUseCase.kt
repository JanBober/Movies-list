package com.domain.usecases

import com.domain.entities.model.MoviesPlayNow
import com.domain.repositories.MoviesListRepository
import io.reactivex.Single

private const val TOKEN_PREFIX = "Bearer"

class GetMoviesListUseCase(private val moviesListRepository: MoviesListRepository) {

    fun execute(token: String): Single<MoviesPlayNow> {
        return moviesListRepository.get("$TOKEN_PREFIX $token")
    }
}
