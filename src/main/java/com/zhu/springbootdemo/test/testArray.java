package com.zhu.springbootdemo.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class testArray {
    public static void main(String[] args) {
        String[] strs = {"aa","bb","cc"};
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        set.add("aa");
        set.add("bb");
        list.add("aa");
        list.add("bb");

        System.out.println(JSON.toJSONString(strs));
    }
}
