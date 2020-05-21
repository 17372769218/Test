package com.course.testng.suite;

import org.testng.annotations.*;

/**
 * @author shkstart
 * @create 2020-05-16 19:46
 */
public class SuiteConfig {
    @BeforeSuite
    public void beforesuite(){
        System.out.println("before suite运行啦");
    }
    @AfterSuite
    public void aftersuite(){
        System.out.println("after suite运行啦");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest运行了");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest运行了");
    }
}
