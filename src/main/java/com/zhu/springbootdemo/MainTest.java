package com.zhu.springbootdemo;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.GetChildrenBuilder;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import sun.java2d.pipe.SpanIterator;

import java.io.IOException;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class MainTest {
    public static void main(String[] args) throws Exception {
//        ZooKeeper zooKeeper = new ZooKeeper("localhost:2181", 5000, (event)->{
//            System.out.println("-");
//        });
//        zooKeeper.create("/aa","woshi".getBytes(),null, CreateMode.PERSISTENT);
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181", retryPolicy);
        client.start();
//        client.create().forPath("/aaa/bb");
        InterProcessMutex lock = new InterProcessMutex(client, "/lock/aa");
        Stack<Integer> stack = new Stack<>();

        for (int i = 0;i<1000;i++){
            int finalI = i;
            Thread thread = new Thread(() -> {
                try {
                    tryGetLockDo(lock, finalI);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }

    public static void tryGetLockDo(InterProcessMutex lock,int i) throws Exception {
        if(lock.acquire(1000000, TimeUnit.MILLISECONDS)) {
            try {
                System.out.println("我抢到锁了。。。。" + i);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.release();

            }
        }
    }

}
