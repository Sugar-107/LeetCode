package com.wenhui.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 程文辉
 */
public class CyclicBarrierTest01 {

    private static  final  int parties = 7;
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(parties,()->{
            System.out.println(true);
        });
        for (int i = 0; i < parties; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(parties)+"线程").start();
        }

//        System.out.println("true = " + true);


    }
}
