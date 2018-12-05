package com.zhu.springbootdemo.test;

import org.junit.Test;

import java.beans.Transient;


public class MainTest {

    public static void main(String[] args) {
        /*SetList<String> strings = new SetList<>();
        strings.add("aaa");
        strings.setSize(10);
        System.out.println(strings.size());
        System.out.println(strings.getSize());*/

        SetList list = new SetList<String>(10);
        for (int i = 0; i < 20; i++) {
            list.push("s"+i);
        }
        list.push("zhuh");
        list.push("s15");
        String str = "";
        for (int i = 0; i < list.getCapacity(); i++) {
            str = str + list.get(i)+"->";
        }
        System.out.println(str);

    }

    @Test
    public void test1(){

    }
}
