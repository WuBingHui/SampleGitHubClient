package com.anthony.net.sample.github.client.main.user_info.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.anthony.net.sample.github.client.dto.response.Commit
import com.anthony.net.sample.github.client.dto.response.common.Error
import com.anthony.net.sample.github.client.model.user_info.repository.CommitsRepository
import com.anthony.net.sample.github.client.network.Resource
import com.anthony.net.sample.github.client.network.RetrofitBuilder
import com.aotter.aotter_suprone_android.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString

class CommitsViewModel(private val commitsRepository: CommitsRepository) : BaseViewModel() {

    val onCommits by lazy { MutableLiveData<Resource<List<Commit>>>() }

    fun getCommits(userName: String,repoName:String) =
        /*viewModelScope是一个綁定到當前viewModel的作用域  當ViewModel被清除時會自動取消该作用域，所以不用擔心oom*/
        viewModelScope.launch {

            try {

                val data = withContext(Dispatchers.IO) {

                    commitsRepository.getCommits(userName,repoName)

                }

                if (data.isSuccessful) {

                    data.body()?.let {

                        val userRepositories =
                            RetrofitBuilder.json.decodeFromString<List<Commit>>(it.string())

                        onCommits.value = Resource.success(userRepositories)

                    }

                } else {

                    data.errorBody()?.let {

                        val error =
                            RetrofitBuilder.json.decodeFromString<Error>(it.string())

                        onCommits.value = Resource.error(error.message, null)

                    }

                }


            } catch (e: Exception) {

                Log.i("dsadsa",e.toString())

                onCommits.value = Resource.error(e.toString(), null)

            }

        }

}