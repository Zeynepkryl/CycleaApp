package com.example.cycleaapp.data.remote.service

import com.example.cycleaapp.domain.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}