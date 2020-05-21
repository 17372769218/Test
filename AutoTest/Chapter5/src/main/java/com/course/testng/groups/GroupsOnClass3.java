package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @author shkstart
 * @create 2020-05-17 17:39
 */
@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void teacher1(){
        System.out.println("这是GroupsOnClass3的teacher1");
    }
    public void teacher2(){
        System.out.println("这是GroupsOnClass3的teacher2");
    }
}
