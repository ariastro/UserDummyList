package io.astronout.usersdummyapp.data.source.remote

import io.astronout.usersdummyapp.data.source.remote.response.GetUsersResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers() : Response<GetUsersResponse>
}
