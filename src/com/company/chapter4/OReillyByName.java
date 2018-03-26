package com.company.chapter4;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class OReillyByName {
    public static void main(String[] args) {
        String hostname = "www.baidu.com";
        try {
            InetAddress[] address = InetAddress.getAllByName(hostname);
            for (InetAddress ia : address) {
                System.out.println(ia);
            }
        } catch (UnknownHostException e) {
            System.out.printf("unknow %s\n", hostname);
        }
    }
}
