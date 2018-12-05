package com.zhu.springbootdemo.test;

public class Person {
    private String name;
    private int age;

    public void run(){
        System.out.println(this.name+"is runing");
    }

    public void swimming(){
        System.out.println(this.name+"is swimming");
    }

    public void haveAcion(){
        this.run();
        this.swimming();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
