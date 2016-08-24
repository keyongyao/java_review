package com.example.net;

import org.omg.CORBA_2_3.portable.OutputStream;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2016/8/12.
 */
public class TestSocket {
}


class MyServerSocket implements Runnable {
    @Override
    public void run() {
        test();
    }

    void test() {
        ServerSocket serverSocket = null;
        try {

            serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            System.out.println("一个客户端建立连接");
            String msg = "欢迎使用welcome";
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write(msg);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

class CilentSocket implements Runnable {
    @Override
    public void run() {
        test();
    }

    void test() {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg = bufferedReader.readLine();
            bufferedReader.close();
            System.out.println(msg);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}