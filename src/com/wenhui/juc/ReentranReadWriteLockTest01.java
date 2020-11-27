package com.wenhui.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 程文辉
 */
public class ReentranReadWriteLockTest01 {

    public static void main(String[] args) throws InterruptedException {

        MyCache cache = new ReentranReadWriteLockTest01().new MyCache();
        for (int i = 0; i < 6; i++) {
            final int num = i;
            new Thread(()->{

                cache.put(String.valueOf(num),num);

            },String.valueOf(i)).start();
        }
//        Thread.sleep(2000);
        for (int i = 0; i < 6; i++) {
            final int num = i;
            new Thread(()->{
                cache.get(String.valueOf(num));
            },String.valueOf(i)).start();
        }


    }

    class MyCache{
        private  Map<String, Object> map = new HashMap<>();
        private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        //读操作

        public void get(String key){
            try {
                readWriteLock.readLock().lock();
                System.out.println("取出数据");
                System.out.println(key +" : "+map.get(key));
            }
            finally{
                readWriteLock.readLock().unlock();
            }
        }

        //写操作
        public void put(String key,Object value){
            try {
                readWriteLock.writeLock().lock();
                map.put(key,value);
                TimeUnit.MILLISECONDS.sleep(new Random().nextInt(2));
                System.out.println("放完数据了");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                readWriteLock.writeLock().unlock();
            }


        }
    }

}
