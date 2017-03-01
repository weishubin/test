package com.person.service;

import org.apache.thrift.TProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by weishubin on 2017/3/1.
 */
public class HelloServerDemo {
    public static void main(String[] args) throws TTransportException {
        TProcessor tProcessor = new HelloWorldService.Processor<HelloWorldImp>(new HelloWorldImp());
        TServerTransport serverTransport = new TServerSocket(9090);
        TServer.Args ag = new TServer.Args(serverTransport).processor(tProcessor);
        TServer server = new TSimpleServer(ag);
        System.out.println("Starting simple server...");
        server.serve();
    }
}
