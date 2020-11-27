package com.wenhui;

public class Test02 {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        char[] c =s.toCharArray();
        for ( int i= 0; i < c.length/2; i++){
            if (c[i] != c[c.length-1 - i]){
                return false;
            }
        }
        return true;


    }

    public static void main(String[] args) {
        System.out.println(new Test02().isPalindrome(123212321));
    }

}
