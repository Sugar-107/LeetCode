package com.bilibili;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test01 {


    public static void main(String[] args) {
        MyRouse myRouse = new MyRouse();
//        ExecutorService service = Executors.newCachedThreadPool();
        ThreadPoolExecutor service = new ThreadPoolExecutor(5,10,2, TimeUnit.SECONDS, new SynchronousQueue<>(),new ThreadPoolExecutor.AbortPolicy());
        // ... do something inside runnable task
        for (int i = 0; i < 10; i++) {
            service.execute(myRouse::showTicks);
        }

        service.shutdown();

    }


}

class MyRouse {
    private AtomicInteger tickes = new AtomicInteger(30);
    public void showTicks(){
        System.out.println(Thread.currentThread().getName()+" "+tickes.decrementAndGet());
        System.out.println(Thread.currentThread().getName()+" "+tickes.decrementAndGet());
    }

}
