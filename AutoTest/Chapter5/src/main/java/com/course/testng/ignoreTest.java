package com.course.testng;

import org.testng.annotations.Test;

/**
 * 忽略测试
 * @Test(enabled = false) 表示不执行这个test
 * @Test(enabled = true) 表示执行这个test
 * @author shkstart
 * @create 2020-05-16 20:12
 */
public class ignoreTest {
    @Test
    public void ignore1(){
        System.out.println("ignore1 执行了");
    }
    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2 执行了");
    }
    @Test(enabled = true)
    public void ignore3(){
        System.out.println("ignore3 执行了");
    }
}
