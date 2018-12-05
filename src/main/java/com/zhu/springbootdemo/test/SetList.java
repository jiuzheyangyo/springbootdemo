package com.zhu.springbootdemo.test;

import java.util.LinkedList;
import java.util.List;

public class SetList<E>{
    private int capacity = 1;

    private LinkedList list = new LinkedList<E>();

   public SetList(int capacity){
       this.capacity = capacity;
   }

   public void push(E e){
       boolean remove = list.remove(e);
       if(remove){
           list.push(e);
       }else {
           if(list.size()+1>capacity){
               list.removeLast();
               list.push(e);
           }else {
               list.push(e);
           }
       }
   }

    public int getCapacity() {
        return capacity;
    }
}
