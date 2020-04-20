package com.hua.mycoroutine

import com.hua.mycoroutine.java_coroutine.Dispatchers
import com.hua.mycoroutine.java_coroutine.GlobalScope
import kotlinx.coroutines.*
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext

/**
 * @author zhangsh
 * @version V1.0
 * @date 2020/4/14 6:40 PM
 */

@InternalCoroutinesApi
fun main() {
    kotlinx.coroutines.GlobalScope.launch(kotlinx.coroutines.Dispatchers.IO) {
        println("before call suspend, thread = ${Thread.currentThread().name}")
        val result = testSuspend()
        println("after call suspend, result = $result")
    }

    GlobalScope.launch(Dispatchers.IO)

    Thread.sleep(2000)
    println("main end")
    Thread.sleep(Long.MAX_VALUE)
}

private suspend fun testSuspend(): String {
    println("before delay")
    val a = 2;
    delay(1000)
    println("after delay")
    return "i am result, a = $a"
}
//
////
//class MyInterceptor : ContinuationInterceptor {
//    override val key: CoroutineContext.Key<*>
//        get() = ContinuationInterceptor
//
//    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
//        return MyContinuation(continuation)
//    }
//}
//
//class TestCompanion {
//    companion object HaHa : MyRun
//}
//
//interface MyRun
//
//class MyContinuation<T>(val continuation: Continuation<T>) : Continuation<T> {
//    override val context = continuation.context
//    override fun resumeWith(result: Result<T>) {
//        println("拦截协程resume")
//        continuation.resumeWith(result)
//    }
//}