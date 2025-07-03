package com.example.cycleaapp.core

import kotlinx.coroutines.CancellationException
import timber.log.Timber

/**
 * Centralized logging utility wrapping Timber.
 * Add any exception types to ignoreList to route through debug instead of error.
 */
object Logger {

    private val ignoreList = mutableListOf<Class<out Throwable>>()

    /**
     * Exceptions to ignore (treat as debug-level)
     */
    @JvmStatic
    fun addIgnoreExceptions(vararg exceptions: Class<out Throwable>) {
        ignoreList.addAll(exceptions)
    }

    @JvmStatic
    fun d(tag: String? = null, message: String?) {
        Timber.d("Debug: %s -> %s", tag, message)
    }

    @JvmStatic
    fun d(tag: String? = null, throwable: Throwable) {
        Timber.d(throwable, "Debug: %s -> %s", tag, throwable.message)
    }

    @JvmStatic
    fun i(tag: String? = null, message: String?) {
        Timber.i("Info: %s -> %s", tag, message)
    }

    @JvmStatic
    fun i(tag: String? = null, throwable: Throwable) {
        Timber.i(throwable, "Info: %s -> %s", tag, throwable.message)
    }

    @JvmStatic
    fun w(tag: String? = null, message: String?) {
        Timber.w("Warn: %s -> %s", tag, message)
    }

    @JvmStatic
    fun w(message: String?, vararg args: Any?) {
        Timber.w(message, *args)
    }

    @JvmStatic
    fun w(tag: String? = null, throwable: Throwable) {
        if (throwable is CancellationException || ignoreList.any { it.isInstance(throwable) }) {
            d(tag, throwable)
        } else {
            Timber.w(throwable, "Warn: %s -> %s", tag, throwable.message)
        }
    }

    @JvmStatic
    fun e(tag: String? = null, message: String?) {
        Timber.e("Error: %s -> %s", tag, message)
    }

    @JvmStatic
    fun e(tag: String? = null, throwable: Throwable, message: String? = null) {
        if (throwable is CancellationException || ignoreList.any { it.isInstance(throwable) }) {
            d(tag, throwable)
        } else {
            if (message.isNullOrBlank()) {
                Timber.e(throwable, "Error: %s", tag)
            } else {
                Timber.e(throwable, "Error: %s -> %s", tag, message)
            }
        }
    }
}
