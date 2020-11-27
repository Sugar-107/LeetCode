package com.wenhui.queueArray;

import java.util.Scanner;

/**
 * 我的循环队列
 * @author 程文辉
 */
public class MyCircularQueue {
    /**
     * 头指针，指向队列的第一个元素，也就是说arr[front] 就是队列的第一个元素
     */
    private static int FRONT;
    /**
     * rear变量的含义：rear指向队列的最后一个元素后一个位置，空出一个空作为约定
     */
    private static int REAR;

    /**
     * 数组最大长度
     */
    private static final int MAXSIZE = 5;

    private final int[] arr = new int[MAXSIZE];


//    private static int length;

    /**
     * 得到数据有效长度
     */
    private int getLength() {
        return (REAR + MAXSIZE - FRONT) % MAXSIZE;
    }

    /**
     * 返回当前队列是否满
     * ( rear + 1 ) % maxSize = front 满
     *
     * @return true代表满了
     */
    private boolean isFull() {
        return (REAR + 1) % MAXSIZE == FRONT;
    }

    /**
     * 返回当前循环队列是否为空
     *
     * @return true表示为空
     */
    private boolean isEmpty() {
        return REAR == FRONT;
    }

    /**
     * 循环队列添加一个数
     */
    private void add(int current) {
        //添加的数即将添加到数组的最后一个位置
        if (isFull()) {
            System.out.println("数据已经满了");
            return;
        }
//        arr[ ( REAR++ ) % MAXSIZE] = current;
        arr[REAR] = current;
        REAR = (REAR + 1) % MAXSIZE;
    }

    private void removeOne() {
        if (isEmpty()) {
            System.out.println("数据空了");
            return;
        }
        FRONT = (FRONT + 1) % MAXSIZE;

    }

    public void getAll() {
        for (int i = 0; i < getLength(); i++) {
            System.out.println(arr[(FRONT + i) % MAXSIZE]);
        }
    }




    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列的案例~~~");

        // 创建一个环形队列
        MyCircularQueue queue = new MyCircularQueue(); //说明设置4, 其队列的有效数据最大是3
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.getAll();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'g': // 取出数据
                    try {
                        queue.removeOne();
//                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
//                        int res = queue.headQueue();
//                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
    }


