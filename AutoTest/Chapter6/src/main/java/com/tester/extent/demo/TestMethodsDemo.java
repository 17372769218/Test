package com.tester.extent.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * @author shkstart
 * @create 2020-05-18 22:00
 */
public class TestMethodsDemo {
    @Test
    public void test1(){
        Assert.assertEquals("1","2");
    }
    @Test
    public void test2(){
        Assert.assertEquals("1","1");
    }
    @Test
    public void log(){
        Reporter.log("这是日志");
        throw new RuntimeException("这是运行时异常");
    }
}
