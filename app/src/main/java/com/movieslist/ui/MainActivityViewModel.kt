package com.movieslist.ui

import androidx.lifecycle.MutableLiveData
import com.domain.entities.model.Auth
import com.domain.entities.model.MoviesPlayNow
import com.domain.entities.model.Token
import com.domain.usecases.GetMoviesListUseCase
import com.domain.usecases.PostUserLoginUseCase
import com.movieslist.base.BaseViewModel
import com.movieslist.base.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getMoviesListUseCase: GetMoviesListUseCase,
    private val postUserLoginUseCase: PostUserLoginUseCase
) : BaseViewModel() {

    val token = MutableLiveData<String>()
    val login = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val action = SingleLiveEvent<Action>()
    val error = SingleLiveEvent<Errors>()

    fun onLoginButtonClick() {
        val auth = Auth().apply {
            username = login.value
            password = this@MainActivityViewModel.password.value
        }
        postUserLoginUseCase
            .login(auth)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    it
                },
                onError = {
                    it
                }
            ).addTo(disposables)
    }

    fun fetchMoviesListApi() {
        getMoviesListUseCase
            .execute(token.value ?: "")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    action.value = Action.MoviesList(it)
                },
                onError = {
                    error.value = Errors.ErrorException(it)
                }
            ).addTo(disposables)
    }

    sealed class Action {
        data class Success(val string: String) : Action()
        data class MoviesList(val moviesPlayNow: MoviesPlayNow) : Action()
    }

    sealed class Errors {
        data class ErrorException(val exception: Throwable) : Errors()
    }
}
