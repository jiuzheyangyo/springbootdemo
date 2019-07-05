package com.zhu.springbootdemo.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Person {

    String name;

    int age;

    public Person(){
        System.out.println("person......");
    }

    public Person(String name){
        System.out.println(name+"--person....");
    }
}
