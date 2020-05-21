package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shkstart
 * @create 2020-05-17 19:56
 */
public class DataProviderTest {
    @Test(dataProvider ="data")
    public void testDataProviderTest(String name,int age){
        System.out.println("name ="+name+"; age="+age);
    }
    @DataProvider(name = "data")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"wjt",12},
                {"zz",11}
        };
        return o;
    }
    @Test(dataProvider = "method")
    public void test1(String name ,int age){
        System.out.println("name ="+name+"; age="+age);
    }
    @Test(dataProvider = "method")
    public void test2(String name ,int age){
        System.out.println("name ="+name+"; age="+age);
    }
    @DataProvider(name = "method")
    public Object[][] provider(Method method){
        Object[][] o = null;
        if (method.getName().equals("test1")){
            o =new Object[][]{
                    {"wjtt",20},
                    {"zzzzz",23}
            };
        }else if (method.getName().equals("test2")){
            o =new Object[][]{
                    {"qqq",50},
                    {"ewww",60}
            };
        }
        return o;
    }
}
