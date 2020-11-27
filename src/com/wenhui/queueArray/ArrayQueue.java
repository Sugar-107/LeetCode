package com.wenhui.queueArray;

/**
 * @author 程文辉
 * 数组
 */

public class ArrayQueue {

    private static int headIndex = 0;
    private static int endIndex = 0;

    private static final int[] DATA = new int[10];


    public static int getHeadIndex() {
        return headIndex;
    }

    public static void setHeadIndex(int headIndex) {
        ArrayQueue.headIndex = headIndex;
    }

    public static int getEndIndex() {
        return endIndex;
    }

    public static void setEndIndex(int endIndex) {
        ArrayQueue.endIndex = endIndex;
    }

    public static int get(){
        return DATA[headIndex--];
    }

    public static void insert(int x){
        DATA[++endIndex] = x;
    }

}
