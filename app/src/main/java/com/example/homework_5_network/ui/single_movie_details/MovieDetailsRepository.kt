package com.example.homework_5_network.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.example.homework_5_network.data.api.TheMovieDBInterface
import com.example.homework_5_network.data.repository.MovieDetailsNetworkDataSource
import com.example.homework_5_network.data.repository.NetworkState
import com.example.homework_5_network.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService: TheMovieDBInterface){

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun  fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int): LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService, compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState>{
        return movieDetailsNetworkDataSource.networkState
    }
}