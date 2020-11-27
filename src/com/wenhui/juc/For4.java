package com.wenhui.juc;

public class For4 {

    public static void main(String[] args) {
        nynn nn = new nynn();
//        nynn nn2 = new nynn();

        new Thread( ()->{
            try {
                for (int i = 0; i < 10; i++) {
                    nn.numadd();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } ,"AA").start();

        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    nn.numdec();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BB").start();

        new Thread( ()->{
            try {
                for (int i = 0; i < 10; i++) {
                    nn.numadd();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } ,"AA2").start();

        new Thread(()->{
            try {
                for (int i = 0; i < 10; i++) {
                    nn.numdec();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BB2").start();
    }

}

class nynn{

    private int num = 0;

    public synchronized void  numadd() throws InterruptedException {
        while (num !=0){
//            System.out.println(Thread.currentThread().getName()+"wait");
            this.wait();
        }
        System.out.println(this+"add");
        System.out.println(Thread.currentThread().getName()+" "+ ++num);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        this.notifyAll();
    }

    public synchronized void  numdec() throws InterruptedException {
        while (num!=1){
//            System.out.println(Thread.currentThread().getName()+"wait");
//            Thread.dumpStack();
            this.wait();
        }
        System.out.println(this+"dec");
        System.out.println(Thread.currentThread().getName()+" "+ --num);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        this.notifyAll();

    }


}
