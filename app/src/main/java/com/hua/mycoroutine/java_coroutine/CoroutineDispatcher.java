package com.hua.mycoroutine.java_coroutine;

/**
 * @author zhangsh
 * @version V1.0
 * @date 2020/4/17 4:14 PM
 */

public abstract class CoroutineDispatcher implements ContinuationInterceptor {

    public abstract void dispatch(Runnable runnable);

    @SuppressWarnings("unchecked")
    @Override
    public final <T> Continuation<T> interceptContinuation(Continuation<T> continuation) {
        return new DispatchedContinuation(continuation, this);
    }

    private static class DispatchedContinuation<T> implements Continuation<T>, Runnable {
        private Continuation<T> mOriginContinuation;
        private CoroutineDispatcher mDispatcher;
        private T result;

        private DispatchedContinuation(Continuation<T> origin, CoroutineDispatcher dispatcher) {
            this.mOriginContinuation = origin;
            this.mDispatcher = dispatcher;
        }

        @Override
        public void resumeWith(final T result) {
            this.result = result;
            mDispatcher.dispatch(this);
        }

        @Override
        public void run() {
            mOriginContinuation.resumeWith(result);
        }
    }
}
