package com.example.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 测试 schedule
 * Created by Administrator on 2016/8/11.
 */

public class TestSchedule {
    void test() {
        Timer timer = new Timer();

        //   timer.schedule(new MyTimer(),new Date(System.currentTimeMillis()+2000));
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new SimpleDateFormat("YYYY-MM-dd").format(System.currentTimeMillis()));
            }
        }, new Date(System.currentTimeMillis() + 3000));
    }

}

class MyTimer extends TimerTask implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我在吃兔子" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
