package com.example.net;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试聊天室的实现
 * Created by Administrator on 2016/8/13.
 */
public class TestChat {

}

class ChatServer implements Runnable {
    List<MyChannel> all = new ArrayList<>();  //保存客户列表
    Socket socket;

    void test() {

        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            while (true) {
                socket = serverSocket.accept();
                MyChannel channel = new MyChannel(socket);
                all.add(channel);
                new Thread(channel).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        test();
    }

    /**
     * 内部类方便读取，所有人列表
     */
    class MyChannel implements Runnable {
        /**
         * 一个内部类和服务端挂钩，发消息非所有client
         */
        private DataInputStream dataInputStream;
        private DataOutputStream dataOutputStream;
        private boolean isRunning = true;

        public MyChannel(Socket client) {
            try {
                dataInputStream = new DataInputStream(client.getInputStream());
                dataOutputStream = new DataOutputStream(client.getOutputStream());

            } catch (IOException e) {
                isRunning = false;
                TestCloseUtility.closeAll(dataInputStream, dataOutputStream);
            }
            System.out.println(this.toString() + "欢迎进入聊天室");

        }

        private String recevieMsg() {
            String str = "";
            try {
                str = dataInputStream.readUTF();
            } catch (IOException e) {
                isRunning = false;
                TestCloseUtility.closeAll(dataInputStream);
            }
            return str;

        }

        private void sendMsg(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            try {
                dataOutputStream.writeUTF(str);
            } catch (IOException e) {
                isRunning = false;
                TestCloseUtility.closeAll(dataOutputStream);
            }
        }

        private void sendOthers() {
            String msg = this.recevieMsg();
            for (MyChannel client : all
                    ) {
                if (client == this)
                    continue;
                client.sendMsg(msg);
            }
        }


        @Override
        public void run() {
            while (isRunning)
                sendOthers();
        }
    }
}


class ChatClient implements Runnable {
    /**
     * 客户端可以发送和接收数据
     */
    void test() {
        try {
            Socket socket = new Socket("127.0.0.1", 9999);

            new Thread(new TestChatMultiSendMsg(socket, this.toString())).start();
            new Thread(new TestChatMultiRecevieMsg(socket, this.toString())).start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        test();
    }
}
