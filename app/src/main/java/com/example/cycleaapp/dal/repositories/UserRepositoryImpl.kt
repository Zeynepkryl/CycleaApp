package com.example.cycleaapp.dal.repositories

import com.example.cycleaapp.dal.datamodel.UserRepository
import com.example.cycleaapp.dal.network.service.ApiService
import com.example.cycleaapp.db.dao.UserDao
import com.example.cycleaapp.db.dao.UserEntity
import com.example.cycleaapp.model.User
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