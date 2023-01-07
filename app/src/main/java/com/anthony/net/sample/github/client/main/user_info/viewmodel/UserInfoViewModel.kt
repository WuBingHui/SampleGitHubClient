package com.anthony.net.sample.github.client.main.user_info.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.anthony.net.sample.github.client.dto.response.Repository
import com.anthony.net.sample.github.client.dto.response.common.Error
import com.anthony.net.sample.github.client.model.user_info.repository.UserInfoRepository
import com.anthony.net.sample.github.client.network.Resource
import com.anthony.net.sample.github.client.network.RetrofitBuilder
import com.anthony.net.sample.github.client.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import retrofit2.HttpException
import java.io.IOException

class UserInfoViewModel(private val userInfoRepository: UserInfoRepository) : BaseViewModel() {

    val onRepositories by lazy { MutableLiveData<Resource<List<Repository>>>() }

    fun getRepositories(loginName: String) =
        /*viewModelScope是一个綁定到當前viewModel的作用域  當ViewModel被清除時會自動取消该作用域，所以不用擔心oom*/
        viewModelScope.launch {

            try {

                val data = withContext(Dispatchers.IO) {

                    userInfoRepository.getRepositories(loginName)

                }

                onRepositories.value = Resource.Success(data)


            } catch (e: HttpException) {

                val errorMessage = e.response()?.errorBody()?.let {
                    RetrofitBuilder.json.decodeFromString<Error>(it.string()).message
                } ?: kotlin.run {
                    null
                }

                onRepositories.value = Resource.Error(errorMessage ?: "An unexpected error occurred")

            } catch (e: IOException) {

                onRepositories.value =
                    Resource.Error("Couldn't reach server. Check your internet connection.")

            }

        }

}