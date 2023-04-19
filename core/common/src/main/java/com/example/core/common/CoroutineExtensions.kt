package com.example.core.common

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun CoroutineScope.safeLaunch(
    execute: suspend () -> Unit,
    catch: (Throwable) -> Unit = {},
    context: CoroutineContext = EmptyCoroutineContext,
): Job {
    return launch(context) {
        try {
            execute.invoke()
        } catch (throwable: Throwable) {
            catch.invoke(throwable)
        }
    }
}