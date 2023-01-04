package com.anthony.net.sample.github.client.main.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.anthony.net.sample.github.client.dto.response.common.Error
import com.anthony.net.sample.github.client.dto.response.common.User
import com.anthony.net.sample.github.client.model.login.repository.LoginRepository
import com.anthony.net.sample.github.client.network.Resource
import com.anthony.net.sample.github.client.network.RetrofitBuilder
import com.aotter.aotter_suprone_android.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString

class LoginViewModel(private val loginRepository: LoginRepository) : BaseViewModel() {

    val onUser by lazy { MutableLiveData<Resource<User>>() }

    fun getUser(userName: String) =
        /*viewModelScope是一个綁定到當前viewModel的作用域  當ViewModel被清除時會自動取消该作用域，所以不用擔心oom*/
        viewModelScope.launch {

            try {

                val data = withContext(Dispatchers.IO) {

                    loginRepository.getUser(userName)

                }

                if (data.isSuccessful) {

                    data.body()?.let {

                        val userRepositories =
                            RetrofitBuilder.json.decodeFromString<User>(it.string())

                        onUser.value = Resource.Success(userRepositories)

                    }

                } else {

                    data.errorBody()?.let {

                        val error =
                            RetrofitBuilder.json.decodeFromString<Error>(it.string())

                        onUser.value = Resource.Error(error.message, null)

                    }

                }


            } catch (e: Exception) {

                onUser.value = Resource.Error(e.toString(), null)

            }

        }

}