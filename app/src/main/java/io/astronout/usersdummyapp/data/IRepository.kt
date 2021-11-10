package io.astronout.usersdummyapp.data

import io.astronout.usersdummyapp.data.source.remote.response.GetUsersResponse
import retrofit2.Response

interface IRepository {

    suspend fun getUsers(): Response<GetUsersResponse>

}