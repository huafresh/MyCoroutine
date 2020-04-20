package com.hua.mycoroutine.java_coroutine;

import static com.hua.mycoroutine.java_coroutine.Intrinsics.COROUTINE_SUSPENDED;

/**
 * @author zhangsh
 * @version V1.0
 * @date 2020/4/17 4:28 PM
 */

public abstract class BaseContinuationImpl implements Continuation<Object> {

    private Continuation<Object> mCompletion;

    public BaseContinuationImpl(Continuation<Object> completion) {
        this.mCompletion = completion;
    }

    @SuppressWarnings("unchecked")
    @Override
    public final void resumeWith(Object result) {
        BaseContinuationImpl current = this;
        Object param = result;
        Continuation completion = mCompletion;
        while (true) {
            Object outcome = current.invokeSuspend(param);
            if (outcome == COROUTINE_SUSPENDED) {
                return;
            }
            if (completion instanceof BaseContinuationImpl) {
                current = (BaseContinuationImpl) completion;
                param = outcome;
                completion = current.mCompletion;
            } else {
                // top level completion
                completion.resumeWith(outcome);
                return;
            }
        }
    }

    protected abstract Object invokeSuspend(Object result);

}
