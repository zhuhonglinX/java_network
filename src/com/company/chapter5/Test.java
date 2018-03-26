package com.company.chapter5;

import java.net.MalformedURLException;
import java.net.URL;

public class Test {
    public static void main(String[] args) {
        String url = "https://www.lincloud.me";
        // URL Protocol part
        try {
            URL u = new URL(url);
            System.out.println(u.getProtocol() + " is support");
        } catch (MalformedURLException e) {
            System.out.println("not support");
        }

        // URL another
        try {
            URL u = new URL("http", "www.lincloud.me", 8080,"/article/001.html");
            System.out.println(u.toString());
        } catch (MalformedURLException e) {
            System.out.println("error");
        }

        //

    }
}
