package com.movieslist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.movieslist.R
import com.movieslist.databinding.ActivityMainBinding
import com.movieslist.base.ktx.showSnackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainAdapter: MoviesPlayNowAdapter
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
            .also {
                it.lifecycleOwner = this
                it.viewModel = mainActivityViewModel
            }
        mainAdapter = MoviesPlayNowAdapter()
            .apply {
                onClick = {}
            }
        binding.getList.recyclerView.adapter = mainAdapter

        mainActivityViewModel.action.observe(this) {
            when (it) {
                is MainActivityViewModel.Action.Success -> {
                    it.string
                }

                is MainActivityViewModel.Action.MoviesList -> {
                    mainAdapter.addListMovie(it.moviesPlayNow)
                    getMoviesList()
                }
            }
        }
        mainActivityViewModel.error.observe(this) {
            when (it) {
                is MainActivityViewModel.Errors.ErrorException -> {
                    it.exception.message?.let { message ->
                        showSnackBar(message)
                    }
                }
            }
        }


    }

    private fun getMoviesList() {
        binding.viewMoviesFlipper.displayedChild =
            binding.viewMoviesFlipper.indexOfChild(findViewById(R.id.get_list))
    }
}
