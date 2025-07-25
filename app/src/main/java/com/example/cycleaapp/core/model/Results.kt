package com.example.cycleaapp.core.model

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Results<out R> {
    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}

data class Success<out T>(val data: T) : Results<T>()
data class Error(val exception: Exception) : Results<Nothing>()