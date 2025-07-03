package com.example.cycleaapp.core

/**
 * Base UseCase class encapsulating business logic execution.
 * @param P - input parameters type
 * @param R - return type
 */
abstract class UseCase<in P, R> {

    /**
     * Invoke this UseCase with given parameters.
     */
    suspend operator fun invoke(parameters: P): R = execute(parameters)

    /**
     * Override this to implement the use case logic.
     * @param parameters input parameters of type P
     * @return result of type R
     */
    @Throws(Exception::class)
    protected abstract suspend fun execute(parameters: P): R
}

/**
 * Extension for UseCase without parameters (Unit).
 * Allows calling useCase() instead of useCase(Unit).
 */
suspend operator fun <R> UseCase<Unit, R>.invoke(): R = this(Unit)
