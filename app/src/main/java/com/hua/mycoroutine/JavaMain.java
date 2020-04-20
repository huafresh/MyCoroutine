package com.hua.mycoroutine;

import com.hua.mycoroutine.java_coroutine.Dispatchers;
import com.hua.mycoroutine.java_coroutine.GlobalScope;


/**
 * @author zhangsh
 * @version V1.0
 * @date 2020-03-17 12:05
 */

public class JavaMain {
    public static void main(String[] args) {

        GlobalScope.launch(Dispatchers.IO);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
