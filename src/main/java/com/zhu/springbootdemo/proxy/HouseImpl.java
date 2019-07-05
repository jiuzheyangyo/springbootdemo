package com.zhu.springbootdemo.proxy;

import com.zhu.springbootdemo.student.Person;

public class HouseImpl implements House{
    @Override
    public void live(String s) {
        System.out.println("living....."+s);
    }

    public String mai(Person p,String action){
        System.out.println(p.getName()+action);
        return p.getName()+action;
    }
}
