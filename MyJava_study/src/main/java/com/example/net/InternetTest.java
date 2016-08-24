package com.example.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class InternetTest {

    public static void main(String[] args) {
        Enumeration<NetworkInterface> networkInterfaces = null;
        try {
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface address = networkInterfaces.nextElement();
            //System.out.println("网卡:" + address.getName());
            Enumeration<InetAddress> ads = address.getInetAddresses();
            while (ads.hasMoreElements()) {
                InetAddress inetAddress = ads.nextElement();
                String ip = inetAddress.getHostAddress();
                if (!ip.contains(":")) {

                    System.out.println(ip);
                }
            }
        }
    }


}




