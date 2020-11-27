package com.wenhui.juc;

public class Test01 {

    public static void main(String[] args) {
        Addin addin = Integer::sum;
        int add = addin.add(1, 2);
        System.out.println("add = " + add);
    }
}

interface Addin{
    public int add(int x ,int y);
}