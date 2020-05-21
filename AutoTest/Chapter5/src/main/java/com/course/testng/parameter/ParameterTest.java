package com.course.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 参数化
 * @author shkstart
 * @create 2020-05-17 19:36
 */
public class ParameterTest {
    @Test
    @Parameters({"name","age"})
    public void paramtest(String name,int age){
        System.out.println("name ="+ name + "; age = " +age);
    }
}
