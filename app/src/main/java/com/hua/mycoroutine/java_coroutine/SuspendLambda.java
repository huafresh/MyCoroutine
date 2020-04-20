package com.hua.mycoroutine.java_coroutine;

/**
 * @author zhangsh
 * @version V1.0
 * @date 2020/4/19 9:53 AM
 */

public abstract class SuspendLambda extends BaseContinuationImpl {
    public SuspendLambda(Continuation<Object> completion) {
        super(completion);
    }
}
