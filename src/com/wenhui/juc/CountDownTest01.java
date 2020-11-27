package com.wenhui.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author 程文辉
 */
public class CountDownTest01 {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(new CountDownTest01().new Word(startSignal,doneSignal),String.valueOf(i)+"?").start();
        }
        Thread.sleep(200);
//        startSignal.countDown();
//        Thread.sleep(200);
        doneSignal.await();
        System.out.println(true);

    }

    class Word implements Runnable{

        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;

        Word(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
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
//                startSignal.await();

                Thread.sleep(200);
//                System.out.println("---------------");
//                System.out.println(startSignal.getCount());
//                doneSignal.
                System.out.println(Thread.currentThread().getName()+" ****"+doneSignal.getCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                doneSignal.countDown();
            }
        }
    }
}
