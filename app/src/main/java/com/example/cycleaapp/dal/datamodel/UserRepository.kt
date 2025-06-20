package com.example.cycleaapp.dal.datamodel

import com.example.cycleaapp.model.User

interface UserRepository {
    suspend fun fetchUsers(): List<User>
}