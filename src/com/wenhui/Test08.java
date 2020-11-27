package com.wenhui;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test08 {
    public int strStr(String haystack, String needle) {
        /*
            定义双指针
        */
        if (needle.length() == 0){
            return 0;
        }
        if(haystack.length() == 0){
            return -1;
        }

        int j = 0;
        int i = 0;
        char firstChar = needle.charAt(j++);
/*      int j = 0;
        int i = 0;
        char firstChar = needle.charAt(j);
        j++;
        //char[] haystackChars = haystack.toCharArray();

        for(;i < haystack.length() && j < needle.length() ;i++){
            if(firstChar == haystack.charAt(i) ){
                firstChar = needle.charAt(j++);
            }else{
                j = 0;
            }
        }*/
        do{
            if(firstChar == haystack.charAt(i++) ){
                firstChar = needle.charAt(j++);
            }else{
                j = 0;
            }
        }while (i < haystack.length() && j < needle.length());


        if(j ==  needle.length()){
            return i - --j;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int strIndex = new Test08().strStr("mississippi"
                ,"mississippi");
        System.out.println(strIndex);

    }


}
