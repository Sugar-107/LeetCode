package com.wenhui.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class tick01 {




    public static void main(String[] args) {

        tikes t = new tikes();
        new Thread( ()->{
            for (int i = 0; i < 40; i++) {
                t.show();
            }
        } , "AA").start();
        new Thread( ()->{
            for (int i = 0; i < 40; i++) {
                t.show();
            }
        } , "BB").start();
        new Thread( ()->{
            for (int i = 0; i < 40; i++) {
                t.show();
            }
        } , "CC").start();
    }
}

class tikes {
    private int tics = 30;
    private Lock lock = new ReentrantLock();
    public void show(){
        lock.lock();
        try {
            if (tics>0){
                System.out.println(Thread.currentThread().getName()+"出售了,剩余"+ (--tics));
            }else {
                throw  new RuntimeException("售空");
            }
        }finally {
            lock.unlock();
        }

    }
}
