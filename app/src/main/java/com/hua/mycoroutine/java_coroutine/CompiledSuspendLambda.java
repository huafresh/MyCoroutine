package com.hua.mycoroutine.java_coroutine;

import android.os.Handler;
import android.os.Looper;

import static java.sql.DriverManager.println;

/**
 * @author zhangsh
 * @version V1.0
 * @date 2020/4/17 4:31 PM
 */

@SuppressWarnings("SameParameterValue")
public class CompiledSuspendLambda extends SuspendLambda {
    private Object result;
    private int label = 0;

    public CompiledSuspendLambda(Continuation<Object> completion) {
        super(completion);
    }

    /**
     * println("before call suspend, thread = ${Thread.currentThread().name}")
     * val result = testSuspend()
     * println("after call suspend, result = $result")
     */

    @Override
    protected Object invokeSuspend(Object result) {
        Object retResult;
        switch (label) {
            case 0:
                String name = Thread.currentThread().getName();
                System.out.println("before call suspend, thread = " + name);
                label = 1;
                Object var1 = compiledTestSuspend(this);
                if (var1 == Intrinsics.COROUTINE_SUSPENDED) {
                    return Intrinsics.COROUTINE_SUSPENDED;
                }
                retResult = var1;
                break;
            case 1:
                retResult = result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        System.out.println("after call suspend, result = " + retResult);
        return null;
    }

    /**
     * private suspend fun testSuspend(): String {
     * println("before delay")
     * val a = 2;
     * delay(1000)
     * println("after delay")
     * return "i am result, a = $a"
     * }
     */
    private Object compiledTestSuspend(Continuation<?> continuation) {

        class SubContinuationImpl extends ContinuationImpl {
            private Object result;
            private int label = 0;
            private int temp;

            private SubContinuationImpl(Continuation completion) {
                super(completion);
            }

            @Override
            protected Object invokeSuspend(Object result) {
                this.result = result;
                this.label |= Integer.MIN_VALUE;
                return compiledTestSuspend(this);
            }
        }

        SubContinuationImpl sm;
        labelSm:
        {
            if (continuation instanceof SubContinuationImpl &&
                    (((SubContinuationImpl) continuation).label & Integer.MIN_VALUE) != 0) {
                ((SubContinuationImpl) continuation).label -= Integer.MIN_VALUE;
                sm = (SubContinuationImpl) continuation;
                break labelSm;
            }
            sm = new SubContinuationImpl(continuation);
        }

        int a;
        switch (sm.label) {
            case 0:
                System.out.println("before delay");
                a = 2;
                sm.temp = a;
                sm.label = 1;
                Object delayResult = compiledDelay(1000L, sm);
                if (delayResult == Intrinsics.COROUTINE_SUSPENDED) {
                    return Intrinsics.COROUTINE_SUSPENDED;
                }
                break;
            case 1:
                a = sm.temp;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        System.out.println("after delay");
        return "i am result, a = " + a;
    }

    /**
     * public suspend fun delay(timeMillis: Long) {
     * ...
     * }
     */
    private Object compiledDelay(final Long timeMillis, final Continuation continuation) {
        new Thread(new Runnable() {
            @SuppressWarnings("unchecked")
            @Override
            public void run() {
                try {
                    Thread.sleep(timeMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 此处应该取出Dispatcher再resume
                continuation.resumeWith(null);
            }
        }).start();
        return Intrinsics.COROUTINE_SUSPENDED;
    }
}
