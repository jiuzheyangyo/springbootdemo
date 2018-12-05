package com.zhu.springbootdemo.test;

public class Student extends Person{
    private String name;
    private int num;

    @Override
    public void run() {
        System.out.println(name+"student is runing");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
