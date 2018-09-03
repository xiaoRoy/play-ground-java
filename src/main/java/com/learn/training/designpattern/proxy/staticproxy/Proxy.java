package com.learn.training.designpattern.proxy.staticproxy;

import com.learn.training.designpattern.proxy.IProxy;

public class Proxy implements IProxy {

    final private IProxy client;


    public Proxy(IProxy client) {
        this.client = client;
    }

    @Override
    public void operate() {
        client.operate();
    }
}
