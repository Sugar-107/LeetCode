package com.wenhui.juc.MyBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author 程文辉
 */
public class BlockingQueueTest01 {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strings = new ArrayBlockingQueue<String>(3);
        strings.add("ss");
        strings.add("bb");
        strings.add("aa");


    }
}
