package com.zhu.springbootdemo.test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.beans.Transient;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.zip.CheckedOutputStream;


public class MainTest {



    public static void main(String[] args) {

       Node root = new Node(12);

       Node node = new Node(1);
       Node node1 = new Node(2);
       Node node2 = new Node(3);
       Node node3 = new Node(4);
       Node node4 = new Node(5);
       Node node5 = new Node(10);
       Node node6 = new Node(-3);
       Node node7 = new Node(3);
       Node node8 = new Node(-5);
       Node node9 = new Node(6);
       Node node10 = new Node(3);
       Node node11 = new Node(-19);
       Node node12 = new Node(9);
       Node node13 = new Node(18);
       Node node14 = new Node(-5);
       Node node15 = new Node(-7);

       root.next  = node;
       node.next = node1;
       node1.next = node2;
       node2.next = node3;
       node3.next = node4;
       node4.next = node5;
       node5.next = node6;
       node6.next = node7;
       node7.next = node8;
       node8.next = node9;
       node9.next = node10;
       node10.next = node11;
       node11.next = node12;
       node12.next = node13;
       node13.next = node14;
       node14.next = node15;

       Node location = root;

       int count = 0;

        while (location != null){
            int sum = 0;
            Node l = location;
            while (true){
                sum += l.val;
                if(l.next == null){

                    break;
                }
                if(sum == 15){
                    count++;
                }
                l = l.next;
            }

            location = location.next;
        }

        System.out.println("count:"+count);


    }

    public static void dd(){
        System.out.println(10/0);
    }

    public static int parseInt(String ss){
        try {
            int i = Integer.parseInt(ss);
            return i;

        } catch (Exception e){
            return -1;
        }
    }
}
