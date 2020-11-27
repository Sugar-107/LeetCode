package com.wenhui.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author 程文辉
 */
public class Test04 {

    class MyResource{

        public synchronized void sendMessage() throws InterruptedException {
            TimeUnit.SECONDS.sleep(4);
            System.out.println("--------message");
        }

        public synchronized void sendEmail(){
            System.out.println("--------Email");
        }

        public void sendHello(){
            System.out.println("--------Hello");
        }


    }

    public static void main(String[] args) throws InterruptedException {
        MyResource myResource = new Test04().new MyResource();


        new Thread(()->{
            try {
                myResource.sendMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } ,"AA").start();
        Thread.sleep(200);
        new Thread(()->{
            myResource.sendEmail();
        } ,"BB").start();

        new Thread(()->{
            myResource.sendHello();
        },"CC").start();
    }


}


