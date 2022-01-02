package io.astronout.usersdummyapp.data

import io.astronout.usersdummyapp.data.source.remote.ApiService
import io.astronout.usersdummyapp.data.source.remote.response.GetUsersResponse
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: ApiService): IRepository {

    override suspend fun getUsers(): Response<GetUsersResponse> = apiService.getUsers()

}
