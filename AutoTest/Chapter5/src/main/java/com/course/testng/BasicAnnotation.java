package com.course.testng;

import org.testng.annotations.*;

/**
 * @author shkstart
 * @create 2020-05-14 22:50
 */
public class BasicAnnotation {
    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testcase1(){
        System.out.println("这是测试用例1");
    }
    @Test
    public void testcase2(){
        System.out.println("这是测试用例2");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod这是测试方法之前运行的");
    }
    @AfterMethod
    public void AfterMethon(){
        System.out.println("afterMethon在测试方法之后运行的");
    }
    @BeforeClass
    public void BeforeClass(){
        System.out.println("BeforeClass在类运行之前运行");
    }
    @AfterClass
    public void AfterClass(){
        System.out.println("AfterClass在类运行之后运行");
    }
    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("BeforeSuite测试套件");
    }
    @AfterSuite
    public void AfterSuite(){
        System.out.println("AfterSuite测试套件");
    }
}
