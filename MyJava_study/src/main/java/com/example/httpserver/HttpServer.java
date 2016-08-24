package com.example.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2016/8/13.
 */
public class HttpServer {
    ServerSocket serverSocket;
    Socket client;
    BufferedReader bufferedReader;

    void start() {
        try {
            serverSocket = new ServerSocket(9999);
            recevieSocket();
            bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String str = null;
            while ((str = bufferedReader.readLine()).length() > 0) {
                stringBuilder.append(str);
                stringBuilder.append("\r\n");
                if (str == null)
                    break;
            }
            System.out.println(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseAble.closeAll(bufferedReader);
        }
    }

    void recevieSocket() {
        try {
            client = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void stop() {
        CloseAble.closeAll(serverSocket);
    }
}
