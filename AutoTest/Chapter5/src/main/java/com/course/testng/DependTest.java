package com.course.testng;

import org.testng.annotations.Test;

/**
 * 依赖测试
 * test2依赖test1
 * 如果test1没执行那么test2也不会执行
 * @author shkstart
 * @create 2020-05-17 18:08
 */
public class DependTest {
    @Test
    public void test1(){
        System.out.println("这是test1");
    }
    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("这是test2");
    }

}
