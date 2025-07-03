package com.example.cycleaapp.core

import kotlinx.coroutines.Dispatchers

object AppDispatcher {

    val main = Dispatchers.Main
    val io = Dispatchers.IO
    val worker = Dispatchers.Default

}