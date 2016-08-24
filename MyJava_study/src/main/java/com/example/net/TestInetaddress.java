package com.example.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Administrator on 2016/8/11.
 */
public class TestInetaddress {
    InetAddress address = null;

    void test() throws UnknownHostException {
        Enumeration<NetworkInterface> networkInterfaces = null;
        try {
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface address = networkInterfaces.nextElement();
            Enumeration<InetAddress> inetAddresses = address.getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress inetAddress = inetAddresses.nextElement();
                String ip = inetAddress.getHostAddress();
                if (!ip.contains(":")) {
                    System.out.println(ip);
                }
            }

        }

    }
}

