package com.hua.mycoroutine.java_coroutine;

/**
 * @author zhangsh
 * @version V1.0
 * @date 2020/4/17 6:17 PM
 */

public abstract class ContinuationImpl extends BaseContinuationImpl {
    @SuppressWarnings("unchecked")
    public ContinuationImpl(Continuation completion) {
        super(completion);
    }
}
