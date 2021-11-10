package io.astronout.usersdummyapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.astronout.usersdummyapp.data.IRepository
import io.astronout.usersdummyapp.data.source.remote.response.GetUsersResponse
import io.astronout.usersdummyapp.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val iRepository: IRepository): ViewModel() {

    private val _users = MutableLiveData<Resource<GetUsersResponse>>()
    val users: LiveData<Resource<GetUsersResponse>>
        get() = _users

    fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            _users.postValue(Resource.loading(null))
            try {
                iRepository.getUsers().let {
                    if (it.isSuccessful) {
                        _users.postValue(Resource.success(it.body()))
                    } else {
                        _users.postValue(Resource.error(it.errorBody().toString(), null))
                    }
                }
            } catch (e: Exception) {
                _users.postValue(Resource.error(e.message.toString(), null))
            }
        }
    }

}