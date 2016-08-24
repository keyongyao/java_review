package com.example.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多客户端的实现
 * Created by Administrator on 2016/8/13.
 */
public class TestMulitSever {

}


class Server implements Runnable {
    void test() {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true) {
                Socket socket = serverSocket.accept();
                String msg = "欢迎使用";
                System.out.println("一个客户端接入");
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(msg);
                dataOutputStream.flush();
                dataOutputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        test();
    }
}

class Client implements Runnable {
    @Override
    public void run() {
        test();
    }

    void test() {
        try {
            Socket client = new Socket("127.0.0.1", 8888);
            DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
            String msg = dataInputStream.readUTF();
            dataInputStream.close();
            System.err.println(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}