package com.course.testng.Thread;

import org.testng.annotations.Test;

/**
 * 多线程测试
 * @author shkstart
 * @create 2020-05-18 19:21
 */
public class ThreadOnAnnotion {
    @Test(invocationCount = 10,threadPoolSize = 4)
    public void test(){
        System.out.println("1");
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }
}
