package com.hua.mycoroutine.java_coroutine;

import android.os.Handler;
import android.os.Looper;

/**
 * @author zhangsh
 * @version V1.0
 * @date 2020/4/17 4:06 PM
 */

public class DispatcherIO extends CoroutineDispatcher {

    @Override
    public void dispatch(Runnable block) {
        Thread thread = new Thread(block, "dispatcher io thread");
        thread.start();
    }
}
