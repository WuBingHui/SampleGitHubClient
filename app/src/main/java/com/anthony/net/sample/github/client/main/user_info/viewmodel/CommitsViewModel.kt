package com.anthony.net.sample.github.client.main.user_info.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.anthony.net.sample.github.client.base.BaseViewModel
import com.anthony.net.sample.github.client.model.common.Error
import com.anthony.net.sample.github.client.model.user_info.Commit
import com.anthony.net.sample.github.client.network.Resource
import com.anthony.net.sample.github.client.network.RetrofitBuilder
import com.anthony.net.sample.github.client.repository.user_info.CommitsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import retrofit2.HttpException
import java.io.IOException

class CommitsViewModel(private val commitsRepository: CommitsRepository) : BaseViewModel() {

    val onCommits by lazy { MutableLiveData<Resource<List<Commit>>>() }

    fun getCommits(userName: String, repoName: String) =
        /*viewModelScope是一个綁定到當前viewModel的作用域  當ViewModel被清除時會自動取消该作用域，所以不用擔心oom*/
        viewModelScope.launch {

            try {

                val data = withContext(Dispatchers.IO) {

                    commitsRepository.getCommits(userName, repoName)

                }

                onCommits.value = Resource.Success(data)

            } catch (e: HttpException) {

                val errorMessage = e.response()?.errorBody()?.let {
                    RetrofitBuilder.json.decodeFromString<Error>(it.string()).message
                } ?: kotlin.run {
                    null
                }

                onCommits.value = Resource.Error(errorMessage ?: "An unexpected error occurred")

            } catch (e: IOException) {

                onCommits.value =
                    Resource.Error("Couldn't reach server. Check your internet connection.")

            }

        }

}