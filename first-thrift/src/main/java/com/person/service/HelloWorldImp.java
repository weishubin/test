package com.person.service;

import org.apache.thrift.TException;

/**
 * Created by weishubin on 2017/3/1.
 */
public class HelloWorldImp implements HelloWorldService.Iface {
    @Override
    public String sayHello(String username) throws TException {
        return "Hello:" + username;
    }
}
