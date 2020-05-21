package com.course.testng.Thread;

import org.testng.annotations.Test;

/**
 * @author shkstart
 * @create 2020-05-18 19:30
 */
public class ThreadOnXml {
    @Test
    public void test1(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }
    @Test
    public void test2(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }
    @Test
    public void test3(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }
}
