package com.zhu.springbootdemo;

import java.lang.reflect.Array;

public class MainTestJVM {
    public static void main(String[] args) throws InterruptedException {
        byte[] a = new byte[2*1024*1024];
        a = new byte[3*1024*1024];
        a = null;
        byte[] b= new byte[24*1024];
        b = new byte[5*1024*1024];
//        a = new byte[2*1024*1024];
//        a = null;
//        a = new byte[50*1024];
//        byte[] b = new byte[2*1024*1024];
    }
}
