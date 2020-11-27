package com.wenhui;

public class Test03 {


    public static void main(String[] args) {
        System.out.println(new Test03().isValid("(("));
    }

    public boolean isValid(String s) {

        if(s.equals("")) {
            return false;
        }
        char[] c = s.toCharArray();
        if(c.length%2 != 0 || c[0] == ']' || c[0] == '}' || c[0] == ')') {
            return false;
        }
        char[] temp = new char[c.length];
        int j = 0;
        for (int i = 0; i < c.length; i++){
            if (c[i] == '(' || c[i] == '{' || c[i] == '['){
                temp[j] = c[i];
                j++;
            }else {
                switch (c[i]){
                    case ')':
                        if ('(' == temp[j-1]) {
                            break;
                        } else {
                            return false;
                        }
                    case ']':
                        if ('[' == temp[j-1])
                        break;
                        else
                            return false;
                    case '}':
                        if ('{' == temp[j-1])
                        break;
                        else
                            return false;
                }
                j--;
            }
        }
        if (j ==0)
            return true;
        else
            return false;
    }
}
