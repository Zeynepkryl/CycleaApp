package com.example.cycleaapp.data.repository

import com.example.cycleaapp.data.remote.service.ApiService
import com.example.cycleaapp.db.dao.UserDao
import com.example.cycleaapp.db.dao.UserEntity
import com.example.cycleaapp.domain.model.User
import com.example.cycleaapp.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: UserDao
) : UserRepository {

    override suspend fun fetchUsers(): List<User> {
        val users = api.getUsers()
        dao.insertAll(users.map { UserEntity(it.id, it.name, it.email) })
        return users
    }
}