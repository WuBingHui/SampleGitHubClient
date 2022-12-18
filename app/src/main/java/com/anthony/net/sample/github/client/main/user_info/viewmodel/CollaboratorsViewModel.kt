package com.anthony.net.sample.github.client.main.user_info.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.anthony.net.sample.github.client.dto.response.Collaborator
import com.anthony.net.sample.github.client.dto.response.Repository
import com.anthony.net.sample.github.client.network.Resource
import com.anthony.net.sample.github.client.network.RetrofitBuilder
import com.aotter.aotter_suprone_android.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import com.anthony.net.sample.github.client.dto.response.common.Error
import com.anthony.net.sample.github.client.model.login.repository.LoginRepository
import com.anthony.net.sample.github.client.model.user_info.repository.CollaboratorsRepository

class CollaboratorsViewModel(private val collaboratorsRepository: CollaboratorsRepository) :
    BaseViewModel() {

    val onCollaborators by lazy { MutableLiveData<Resource<List<Collaborator>>>() }

    fun getUserRepositories(userName: String, repoName: String) =
        /*viewModelScope是一个綁定到當前viewModel的作用域  當ViewModel被清除時會自動取消该作用域，所以不用擔心oom*/
        viewModelScope.launch {

            try {

                val data = withContext(Dispatchers.IO) {

                    collaboratorsRepository.getCollaborators(userName, repoName)

                }

                if (data.isSuccessful) {

                    data.body()?.let {

                        val userRepositories =
                            RetrofitBuilder.json.decodeFromString<List<Collaborator>>(it.string())

                        onCollaborators.value = Resource.success(userRepositories)

                    }

                } else {

                    data.errorBody()?.let {

                        val error =
                            RetrofitBuilder.json.decodeFromString<Error>(it.string())

                        onCollaborators.value = Resource.error(error.message, null)

                    }

                }


            } catch (e: Exception) {

                onCollaborators.value = Resource.error(e.toString(), null)

            }

        }

}