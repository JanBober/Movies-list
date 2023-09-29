package com.domain.repositories

import com.domain.entities.model.MoviesPlayNow
import io.reactivex.Single

interface MoviesListRepository {

    fun get(token: String): Single<MoviesPlayNow>
}
