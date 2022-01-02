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
import javax.inject.Inject

class MainViewModel @Inject constructor(private val iRepository: IRepository): ViewModel() {

    private val _users = MutableLiveData<Resource<GetUsersResponse>>()
    val users: LiveData<Resource<GetUsersResponse>>
        get() = _users

    fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            _users.postValue(Resource.Loading())
            try {
                iRepository.getUsers().let {
                    if (it.isSuccessful) {
                        it.body()?.let { body ->
                            _users.postValue(Resource.Success(body))
                        }
                    } else {
                        _users.postValue(Resource.Error(it.errorBody().toString()))
                    }
                }
            } catch (e: Exception) {
                _users.postValue(Resource.Error(e.message.toString()))
            }
        }
    }

}