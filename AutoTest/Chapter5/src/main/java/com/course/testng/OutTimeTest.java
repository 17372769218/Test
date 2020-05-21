package com.course.testng;

import org.testng.annotations.Test;

/**
 * 超时测试
 * @author shkstart
 * @create 2020-05-18 19:55
 */
public class OutTimeTest {
    @Test(timeOut = 3000)//单位为毫秒值
    public void testSuccess ()throws Exception{
        Thread.sleep(2000);
    }
    @Test(timeOut = 3000)
    public void testFailed()throws Exception{
        Thread.sleep(3500);
    }
}
