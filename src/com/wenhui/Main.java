package com.wenhui;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().reverse(1534236469));
    }

}


class Solution2 {
    public int reverse(int x) {

        final int INT_MAX = Integer.MAX_VALUE;
        final int INT_MIN = Integer.MIN_VALUE;
        int rev = 0;
        while(x!=0){
            int now = x%10;
            x/=10;

            if( rev > INT_MAX/10 || (rev == INT_MAX/10 && now >7)){
        // if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)){
                return 0;
            }else if(rev < INT_MIN/10 || (rev == INT_MIN/10 && now < -8 )){
                return 0;
            }else{
                rev = rev *10 + now;
            }
        }

        return rev;
    }
}