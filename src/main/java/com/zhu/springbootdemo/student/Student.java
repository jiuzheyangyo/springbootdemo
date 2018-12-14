package com.zhu.springbootdemo.student;

public class Student extends Person {
    public Student(){
        //super();
        System.out.println("student");
    }

    public Student (String name){
        super(name);
        System.out.println(name+"....");
    }
}
