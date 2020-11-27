package com.wenhui.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 程文辉
 */
public class FutuerTaskTest01 {
    class MyThread implements Runnable{

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

        }
    }
    class MyThread2 implements Callable<Integer> {

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public Integer call() throws Exception {
            System.out.println(1);
            return 1;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        FutureTask<Integer> futureTask = new FutureTask<Integer>(new FutuerTaskTest01().new MyThread2());
//        new Thread(futureTask).start();
        FutureTask<Integer> futureTask = new FutureTask<Integer>( ()->{
            return 0;
        } );
        new Thread(futureTask).start();
        while (!futureTask.isDone()){
//            System.out.println(1);
        }
        System.out.println(futureTask.get());
    }

}
