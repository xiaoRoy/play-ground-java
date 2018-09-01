package com.learn.training.proxy.dynamicproxy;

import com.learn.training.proxy.Actor;
import com.learn.training.proxy.IProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    public static void main(String[] args) {
        new DynamicProxy().whatAnother();
    }

    private void what() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Proxy.getProxyClass(IProxy.class.getClassLoader(), IProxy.class);
        Constructor<?> constructor = clazz.getConstructor(InvocationHandler.class);
        IProxy proxy = (IProxy) constructor.newInstance(new LogHandler(new Actor()));
        proxy.operate();
    }

    private void whatAnother(){
        final Class<?>[] classes = {IProxy.class};
        IProxy proxy = (IProxy)Proxy.newProxyInstance(IProxy.class.getClassLoader(), classes, new LogHandler(new Actor()));
        proxy.operate();
    }

}
