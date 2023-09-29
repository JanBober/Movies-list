package com.data.client.api

import com.domain.entities.model.MoviesPlayNow
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header

interface MovieApi {

    @GET("movie/now_playing")
    fun getMovieNowPlaying(
        @Header("Authorization") authorization: String
    ): Single<MoviesPlayNow>
}
