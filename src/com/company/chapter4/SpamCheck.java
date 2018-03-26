package com.company.chapter4;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SpamCheck {
    public static final String BLACKHOLE = "sbl.spamhaus.org";

    public static void main(String[] args) throws UnknownHostException {
        for (String arg : args) {
            if (isSpammer(arg)) {
                System.out.println(arg + " is a known spammer.");
            } else {
                System.out.println(arg + " appears legitimate.");
            }
        }
    }

    private static boolean isSpammer(String arg) {
        try {
            String query = BLACKHOLE;
            InetAddress address = InetAddress.getByName(arg);
            byte[] quad = address.getAddress();
            for (byte b : quad) {
                int ub = b < 0 ? b + 256 : b;
                query = ub + "." + query;
            }
            address = InetAddress.getByName(query);
            System.out.println(address);
            return true;
        } catch (UnknownHostException e) {
            return false;
        }
    }
}
