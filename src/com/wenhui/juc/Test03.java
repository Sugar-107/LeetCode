package com.wenhui.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *两个线程，一个线程打印1-52，另一个打印字母A-Z打印顺序为12A34B...5152Z,
 *
 * 要求用线程间通信
 * @author 程文辉
 */
public class Test03 {

    public static void main(String[] args) {
        MyResourse myResourse = new MyResourse();
        new Thread( ()->{
            for (int i = 0; i < 26; i++) {
                myResourse.outNum();
            }
        } ,"AA").start();
        new Thread( ()->{
            for (int i = 0; i < 26; i++) {
                myResourse.outLetter();
            }
        } ,"BB").start();

    }
}

class MyResourse{
    private int a = 0;
    private char mychar = 'A';
    private Boolean flag = true;
    private final Lock lock = new ReentrantLock();
    private final Condition c1 = lock.newCondition();
    private final Condition c2 = lock.newCondition();
    public void outNum(){
        lock.lock();
        try {
            while (!flag){
                c1.await();
            }
            System.out.println(++a);
            System.out.println(++a);
            flag = false;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void outLetter(){
        lock.lock();
        try {
            while (flag){
                c2.await();
            }
            System.out.println((char)mychar++);
            flag = true;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
