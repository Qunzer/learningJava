package com.javalearning.guavaexample.reflection;

import com.google.common.reflect.AbstractInvocationHandler;
import com.google.common.reflect.Reflection;

import java.lang.reflect.Method;

/**
 * Created by renqun.yuan on 2015/11/4.
 */
public class ReflectionExample {
    public static void main(String[] args) {
        ProxyTest proxyTest = Reflection.newProxy(ProxyTest.class, new AbstractInvocationHandler() {
            @Override
            protected Object handleInvocation(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before");
                Object invoke = method.invoke(new ProxyTestImpl(), args);
                System.out.println("after");
                return invoke;
            }
        });

        proxyTest.testProxy();
    }
}