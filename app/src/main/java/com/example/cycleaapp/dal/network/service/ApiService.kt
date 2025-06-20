package com.example.cycleaapp.dal.network.service


import com.example.cycleaapp.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}