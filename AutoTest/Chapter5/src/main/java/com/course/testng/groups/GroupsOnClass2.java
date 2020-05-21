package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * @author shkstart
 * @create 2020-05-17 17:38
 */
@Test(groups = "stu")
public class GroupsOnClass2 {
    public void stu1(){
        System.out.println("这是GroupsOnClass2的stu1");
    }
    public void stu2(){
        System.out.println("这是GroupsOnClass2的stu2");
    }
}
