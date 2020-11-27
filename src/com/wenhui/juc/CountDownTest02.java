package com.wenhui.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author 程文辉
 */
public class CountDownTest02 {

    class Worderunable implements Runnable{

        private final CountDownLatch doneSignal;
        private final int i;

        Worderunable(CountDownLatch doneSignal, int i) {
            this.doneSignal = doneSignal;
            this.i = i;
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            try {
                doWork(i);
            }finally {
                doneSignal.countDown();
            }
        }

        void doWork(int i){
            System.out.println("work执行了"+i+"次数");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch doneSignal = new CountDownLatch(6);
//        Executor e = Executors.newFixedThreadPool(6);
//
//        for (int i = 0; i < 6; i++) {
//            e.execute(new CountDownTest02().new Worderunable(countDownLatch,1));
//        }
//        countDownLatch.await();
        for (int i = 0; i < 6; i++) {
            new Thread(new CountDownTest02().new Worderunable(doneSignal,i)).start();
        }
        doneSignal.await();
        System.out.println("true = " + true);

    }
}

