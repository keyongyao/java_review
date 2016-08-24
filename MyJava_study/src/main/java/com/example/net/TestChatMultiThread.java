package com.example.net;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Administrator on 2016/8/13.
 */
public class TestChatMultiThread {

}

class TestChatMultiSendMsg implements Runnable {
    private BufferedReader bufferedReader = null;
    private DataOutputStream dataOutputStream = null;
    private Socket server;
    private boolean isRunning = true;
    private String who;

    public TestChatMultiSendMsg(Socket server, String who) {
        this.who = who;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.server = server;
    }

    public String getMsg() {
        String msg = "";
        try {
            msg = bufferedReader.readLine();
        } catch (IOException e) {
            isRunning = false;
            TestCloseUtility.closeAll(dataOutputStream, bufferedReader);
        }
        return msg;
    }

    public void send() {
        String msg;
        try {
            dataOutputStream = new DataOutputStream(server.getOutputStream());
            dataOutputStream.writeUTF(msg = getMsg());
            System.out.println(who + " 发送消息：" + msg);
            dataOutputStream.flush();
        } catch (IOException e) {
            isRunning = false;
            TestCloseUtility.closeAll(dataOutputStream, bufferedReader);
        }
    }

    @Override

    public void run() {
        while (isRunning) {
            send();
        }
    }
}

class TestChatMultiRecevieMsg implements Runnable {
    private Socket client = null;
    private DataInputStream dataInputStream = null;
    private boolean isRunning = true;
    private String who;

    public TestChatMultiRecevieMsg(Socket client, String who) {
        this.who = who;
        this.client = client;
    }

    public String recevieMSg() {
        String recevieMsg = "";
        try {
            dataInputStream = new DataInputStream(client.getInputStream());
            recevieMsg = dataInputStream.readUTF();
        } catch (IOException e) {
            isRunning = false;
            TestCloseUtility.closeAll(dataInputStream);
        }
        return recevieMsg;
    }

    @Override
    public void run() {
        while (isRunning)
            System.out.println(who + "  收到消息：" + recevieMSg());
    }
}

