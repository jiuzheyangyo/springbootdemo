package com.zhu.springbootdemo.proxy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Proxy.newProxyInstance(House.class.getClassLoader(),House.class,()->{
           return null;
        });
    }
}
