package com.zhu.springbootdemo.cache;


import com.google.common.base.*;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import io.lettuce.core.output.StatusOutput;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;

public class MainTest1 {
    public static void main(String[] args) {
        String s ="()";
        Stack<Character> stack = new Stack<>();

        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            System.out.println(c);
            System.out.println(stack.peek().equals(c));
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        char c = 'c';
        switch(c){
            case 'C':
                System.out.println("aaa");
                break;
        }
        System.out.println(stack.isEmpty());
    }
}
