package com.wenhui.juc;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author 程文辉
 */
public class SemaphoreTest01 {


    public static void main(String[] args) {
        Semaphore e = new Semaphore(3);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 6; i++) {
            new Thread(()->{

                try {
                    e.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到了车位");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                    System.out.println(Thread.currentThread().getName()+"退出了车位");

                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }finally {
                    e.release();
                }
            },String.valueOf(i)).start();
        }
    }

}
