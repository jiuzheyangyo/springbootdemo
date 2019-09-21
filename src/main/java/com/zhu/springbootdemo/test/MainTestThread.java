package com.zhu.springbootdemo.test;

public class MainTestThread {
    public static void main(String[] args) throws InterruptedException {
        TestThread testThread = new TestThread();
        testThread.doSome();

        Thread.sleep(10000);
        synchronized (testThread){
            testThread.notifyAll();
        }
        System.out.println("唤醒");
        Thread.sleep(3000000);
        System.out.println("finished");
    }
}

class TestThread{
    public void doSome(){
        Thread thread1 = new Thread(() -> {
            Thread thread = Thread.currentThread();
            System.out.println("start...." + thread.getName());
            try {
                synchronized (this) {
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                synchronized (this) {
                    System.out.println("finish...." + thread.getName());
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread-1");

        Thread thread2 = new Thread(() -> {
            Thread thread = Thread.currentThread();
            System.out.println("start...." + thread.getName());
            try {
                synchronized (this) {
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                synchronized (this) {
                    System.out.println("finish...." + thread.getName());
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread-2");

        thread1.start();

        thread2.start();
    }
}
