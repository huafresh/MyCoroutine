package com.hua.mycoroutine.java_coroutine;

/**
 * @author zhangsh
 * @version V1.0
 * @date 2020/4/17 4:00 PM
 */

public interface ContinuationInterceptor {

    <T> Continuation<T> interceptContinuation(Continuation<T> continuation);

}
