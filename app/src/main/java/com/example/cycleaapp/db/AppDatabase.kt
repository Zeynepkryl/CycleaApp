package com.example.cycleaapp.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cycleaapp.db.dao.UserDao
import com.example.cycleaapp.db.dao.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}