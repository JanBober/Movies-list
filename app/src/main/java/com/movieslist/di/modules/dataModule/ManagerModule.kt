package com.movieslist.di.modules.dataModule

import com.data.client.api.MovieApi
import com.data.client.api.UserApi
import com.data.repositories.MoviesListRepositoryImpl
import com.data.repositories.UserRepositoryImpl
import com.domain.repositories.MoviesListRepository
import com.domain.repositories.UserRepository
import com.domain.usecases.GetMoviesListUseCase
import com.domain.usecases.PostUserLoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ManagerModule {

    @Provides
    @Singleton
    internal fun provideMoviesListRepository(
        movieApi: MovieApi
    ): MoviesListRepository {
        return MoviesListRepositoryImpl(movieApi)
    }

    @Provides
    @Singleton
    fun provideGetMoviesListUseCase(moviesListRepository: MoviesListRepository): GetMoviesListUseCase {
        return GetMoviesListUseCase(moviesListRepository)
    }

    @Provides
    @Singleton
    internal fun provideUserRepository(
        userApi: UserApi
    ): UserRepository {
        return UserRepositoryImpl(userApi)
    }

    @Provides
    @Singleton
    fun providePostUserUseCase(userRepository: UserRepository): PostUserLoginUseCase {
        return PostUserLoginUseCase(userRepository)
    }
}
