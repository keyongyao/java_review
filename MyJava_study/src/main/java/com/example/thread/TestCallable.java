package com.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Thread 没有跑出异常 和 返回值
 * callable 解决这个问题 创建繁琐
 * Created by Administrator on 2016/8/9.
 */
public class TestCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {

        return 9999;
    }

    void test() {
        ExecutorService service = Executors.newFixedThreadPool(2);  //第一创建执行器服务线程池数
        Future<Integer> future = service.submit(this); //第二：添加实现类
        Integer num = null;
        try {
            num = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(num);
        service.shutdownNow();  //第三：停止服务
    }
}
