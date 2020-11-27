package com.wenhui;

import org.junit.Test;

import java.util.Optional;

/**
 * 排序方法
 * @author 程文辉
 */
public class MySort {

/**
 * 冒泡排序 (升序)
 * 从第一个开始冒泡
 *
 *     从第一个开始比较相邻两个元素比较大小,如果前面元素小于后面元素,交换位置.
 *     经过一次循环最小的元素会排到最后面.
 *     最小的元素在最后面了,后面的循环不必参与了
 *     从后往前排
 */
    @Test
    public void bubbleSort(){
        int[] arr = new int[]{12,45,34,486,472,12,45,31};

        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j]>arr[j+1]){
                    int swap = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = swap;
                }
            }
        }
        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }

    /**
     * 选择排序
     * 每次选择一个最大的数，放在数组的末位
     *   由此需要假设第一个数为最大的数
     */
    @Test
    public void selectSort(){
        int[] arr = new int[]{12,45,34,486,472,12,45,31};

        for (int i = 0; i < arr.length; i++) {
            int max = i; //假设最大数的坐标为0

            for (int j = i; j < arr.length; j++) {
//                arr[max]
                if (arr[max]<arr[j]){
//                    arr[]
                    max = j;
                }
            }
            int swap = arr[max];
            arr[max] = arr[i];
            arr[i] = swap;
        }
        for (int i : arr) {
            System.out.println("i = " + i);
        }

    }

    /**
     * 插入排序
     * 将数据插入到排好序的队列中，默认排序为升序
     */
    @Test
    public void insertionSort(){
        int[] arr = new int[]{12,12,588,688,472,12,45,31};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                //和前面的比大小,小的到前面去,从后往前比
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;

            }
        }
        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }

    @Test
    public void spel(){
        String name = "nullss";
        Optional<String> s = Optional.ofNullable(name)
                .map(x -> x.toLowerCase());
        System.out.println("s = " + s);
//

//        System.out.println(s);
    }



}
