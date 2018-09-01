package com.learn.training.proxy.dynamicproxy;

import com.learn.training.proxy.IProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

    final private IProxy client;

    public LogHandler(IProxy client) {
        this.client = client;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(client, args);
        return result;
    }
}
