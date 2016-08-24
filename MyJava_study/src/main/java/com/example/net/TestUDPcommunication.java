package com.example.net;

import java.io.IOException;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2016/8/11.
 */
public class TestUDPcommunication {


}

class UDPserver implements Runnable {
    void readyReceiver() {
        DatagramSocket socket = null;
        try {

            socket = new DatagramSocket(8888);
            byte[] receiver = new byte[1024];
            DatagramPacket packet = new DatagramPacket(receiver, 0, receiver.length);
            socket.receive(packet);
            byte[] data = packet.getData();
            int len = packet.getLength();
            System.out.println(new String(data, 0, len));
        } catch (BindException b) {

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }

    @Override
    public void run() {
        readyReceiver();
    }
}

class UDPclient implements Runnable {
    void sendData() {
        DatagramSocket client = null;
        try {

            client = new DatagramSocket(6666);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        byte[] str = "i love money".getBytes();
        DatagramPacket packet = null;
        packet = new DatagramPacket(str, 0, str.length, new InetSocketAddress("localhost", 8888));
        try {
            client.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
    }

    @Override
    public void run() {
        sendData();
    }
}