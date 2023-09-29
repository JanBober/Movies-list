package com.data.repositories

import com.data.client.api.MovieApi
import com.domain.entities.model.MoviesPlayNow
import com.domain.repositories.MoviesListRepository
import io.reactivex.Single

class MoviesListRepositoryImpl(private val movieApi: MovieApi) : MoviesListRepository {

    override fun get(token: String): Single<MoviesPlayNow> {
        return movieApi.getMovieNowPlaying(token)
    }

}
