package com.hua.mycoroutine.java_coroutine;

/**
 * @author zhangsh
 * @version V1.0
 * @date 2020/4/17 4:04 PM
 */

public class GlobalScope {

    public static Job launch(CoroutineDispatcher dispatcher) {
        StandaloneCoroutine coroutine = new StandaloneCoroutine();
        CompiledSuspendLambda blockContinuation = new CompiledSuspendLambda(coroutine);
        Continuation<Object> proxyContinuation = dispatcher.interceptContinuation(blockContinuation);
        proxyContinuation.resumeWith(null);
        return coroutine;
    }


}
