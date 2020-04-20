package com.hua.mycoroutine.java_coroutine;

/**
 * @author zhangsh
 * @version V1.0
 * @date 2020/4/17 4:02 PM
 */

public interface Continuation<T> {
    void resumeWith(T result);
}
