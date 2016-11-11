package com.weishubin.test.es;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author weishubin
 */
public class ESTest {
    public static void main(String[] args) throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", "vms-vfilter-cluster")
                .put("client.transport.ping_timeout", "10s")
                .put("client.transport.sniff", true).build();
        TransportClient client = TransportClient.builder().settings(settings).build();
        String[] servers = new String[]{"host"};
        for (String s : servers) {
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(s), 9300));
        }

        GetResponse response = client.prepareGet("vfilter", "videoinfo", "139282148").get();

        client.close();


    }
}
