package com.example.administrator.rxjavademo.bean;

import java.util.List;

/**
 * 类名称：
 * 类描述：
 * 创建人：quzongyang
 * 创建时间：2016/8/2. 16:01
 * 版本：
 */
public class Student {

    public String name;
    public List<Course> coursesList;//所修的课程
}

 class Course{
    private String name;//课程名
    private String id;
}
