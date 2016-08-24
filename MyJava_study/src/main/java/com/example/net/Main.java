package com.example.net;

import java.net.BindException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Administrator on 2016/8/11.
 */
public class Main {
    public static void main(String[] args) {
        //   new TestURL().test();
       /* //
        try {
            new TestInetaddress().test();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }*/
        //  new Thread(new UDPserver()).start();
        // new Thread(new UDPclient()).start();
        // new Thread(new MyServerSocket()).start();
        //new Thread(new CilentSocket()).start();
      /*  new Thread(new Server()).start();
        for (int i = 0; i <10 ; i++) {
            new Thread(new Client()).start();
        }*/

//       new Thread(new ChatServer()).start();
//        new Thread(new ChatClient()).start();


        new Thread(new ChatServer()).start();

        new Thread(new ChatClient()).start();  //自己的线程，不收自己的消息
        new Thread(new ChatClient()).start();  //自己的线程，不收自己的消息
    }

}