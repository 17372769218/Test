package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * @author shkstart
 * @create 2020-05-17 10:03
 */
public class GroupsOnMethod {
    @BeforeGroups(groups = {"server"})
    public void beforeGroupsOnServer(){
        System.out.println("这是在服务端组之前执行的");
    }
    @AfterGroups ("server")
    public void afterGroupsOnServer(){
        System.out.println("这是在服务端组之后执行的");
    }
    @BeforeGroups(value = "client")
    public void beforeGroupsOnClient(){
        System.out.println("这是在客户端组之前执行的");
    }
    @AfterGroups ("client")
    public void afterGroupsOnClient(){
        System.out.println("这是在客户端组之后执行的");
    }
    @Test(groups = {"server"})
    public void test1(){
        System.out.println("这是服务端组测试1");
    }
    @Test(groups = {"server"})
    public void test2(){
        System.out.println("这是服务端组测试2");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("这是客户端组测试1");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("这是客户端组测试2");
    }

}
