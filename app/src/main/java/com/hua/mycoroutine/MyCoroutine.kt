package com.hua.mycoroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.android.HandlerDispatcher
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.startCoroutine

/**
 * @author zhangsh
 * @version V1.0
 * @date 2020/4/15 9:48 AM
 */

fun <T> testBlock(
    scope: CoroutineScope,
    completion: Continuation<Unit>,
    block: suspend CoroutineScope.() -> Unit
) {
    GlobalScope.launch {  }
}

class Test : MainCoroutineDispatcher(){
    override val immediate: MainCoroutineDispatcher
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun dispatch(context: CoroutineContext, block: Runnable) {

    }
}