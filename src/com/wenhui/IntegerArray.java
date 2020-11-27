package com.wenhui;

public class IntegerArray {

    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * @param nums1 有序整数数组 nums1
     * @param m  数组一的长度
     * @param nums2 有序整数数组 nums2
     * @param n 数组二的长度
     * @return 返回排好序的新数组
     */
    public int[] mergeOrderedArray(int[] nums1, int m, int[] nums2, int n){

        int p = m+n - 1 ;
        int p1 = m - 1 ;
        int p2 = n - 1;

        for( ; p1>=0 &&p2>=0 ; p-- ){
            if(nums2[p2] > nums1[p1] ){
                nums1[p] = nums2[p2];
                p2--;
            }else{
                nums1[p] = nums1[p1];
                p1--;
            }
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

        return nums1;
    }

    public static void main(String[] args) {

        //System.out.println(new int[]{}.length);

        int[] arr =  new IntegerArray().mergeOrderedArray(new int[]{3,4,5,0,0},3,new int[]{1,2},2);
        for (int arr1: arr
             ) {
            System.out.print(arr1+" ");
        }
    }

}
