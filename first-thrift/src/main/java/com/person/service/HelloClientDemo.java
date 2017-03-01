package com.person.service;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by weishubin on 2017/3/1.
 */
public class HelloClientDemo {
    public static final String SERVER_IP = "localhost";
    public static final int SERVER_PORT = 9090;
    public static final int TIMEOUT = 3000;

    public static void main(String[] args) {
        new HelloClientDemo().startClient("world");
    }

    public void startClient(String userName) {
        TTransport transport = null;

        try {
            transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
            TProtocol protocol = new TBinaryProtocol(transport);
            HelloWorldService.Client client = new HelloWorldService.Client(protocol);
            transport.open();

            String result = client.sayHello(userName);
            System.out.println("result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (transport != null) {
                transport.close();
            }
        }

    }

}
