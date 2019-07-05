package com.zhu.springbootdemo.proxy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {

        House house = new HouseImpl();

        House o = (House)Proxy.newProxyInstance(House.class.getClassLoader(), HouseImpl.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(JSON.toJSONString(proxy));
                System.out.println(JSON.toJSONString(method));
                System.out.println(JSON.toJSONString(args));
                method.invoke(house, args);
                return null;
            }
        });

        o.live("aaa");
    }
}
