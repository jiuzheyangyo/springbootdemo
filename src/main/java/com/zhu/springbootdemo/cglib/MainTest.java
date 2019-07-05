package com.zhu.springbootdemo.cglib;

import com.alibaba.fastjson.JSON;
import com.zhu.springbootdemo.proxy.HouseImpl;
import com.zhu.springbootdemo.student.Person;
import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;
import java.util.PrimitiveIterator;

public class MainTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        HouseImpl house = new HouseImpl();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HouseImpl.class);
        MethodInterceptor methodInterceptor1 = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println(JSON.toJSONString(o));
                System.out.println(JSON.toJSONString(method));
                System.out.println(JSON.toJSONString(objects));
//                System.out.println(JSON.toJSONString(methodProxy));
                return method.invoke(house, objects);

            }
        };
        MethodInterceptor methodInterceptor2 = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println(JSON.toJSONString(111));
                return method.invoke(house, objects);

            }
        };

        enhancer.setCallbacks(new MethodInterceptor[]{methodInterceptor1,methodInterceptor2});
        enhancer.setCallbackFilter(new CallbackFilter() {
            @Override
            public int accept(Method method) {
                return 0;
            }
        });
        HouseImpl o = (HouseImpl)enhancer.create();
        Class aClass = enhancer.createClass();
        System.out.println(aClass);
        o.mai(new Person("zhu",12),"chifan");
    }
}
