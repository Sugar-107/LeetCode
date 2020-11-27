package com.wenhui.jvm;

public class Test01 {

    public static void main(String[] args) {
//        int i = 2+3;
        int i = 2;
        int j = 3;
        int k = i+j;
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
