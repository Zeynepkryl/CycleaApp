package com.example.cycleaapp.domain.repository

import com.example.cycleaapp.domain.model.User

interface UserRepository {
    suspend fun fetchUsers(): List<User>
}