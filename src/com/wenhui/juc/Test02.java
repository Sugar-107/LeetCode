package com.wenhui.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 进程间定制化通信
 * @author 程文辉
 */
public class Test02 {

    public static void main(String[] args) {
        MySource mySource = new MySource();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                mySource.to1();
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                mySource.to2();
            }
        },"BB").start();
        new Thread( ()->{
            for (int i = 0; i < 10; i++) {
                mySource.to0();
            }
        },"CC").start();
    }
}

/**
 * 资源类
 * @author 程文辉
 */
class MySource{
    private int num = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition c1 = lock.newCondition();
    private final Condition c2 = lock.newCondition();
    private final Condition c3 = lock.newCondition();

    public void to1(){
        lock.lock();
        try {
            while (this.num!=0){
                c1.await();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println("to1执行了");
            }
            this.num=1;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void to2(){
        lock.lock();
        try {
            while (this.num!=1){
                c2.await();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println("to2执行了");
            }
            this.num=2;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void to0(){
        lock.lock();
        try {
            while (this.num!=2){
                c3.await();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println("to0执行了");
            }
            this.num=0;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
