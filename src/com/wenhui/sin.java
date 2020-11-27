package com.wenhui;

public class sin {
    //第一种
    private static sin sin1 = new sin();

    private sin(){}

    public static sin newInstance(){
        return sin1;
    }
    //第二种
    private static sin sin2 = null;

    public static  sin newInstance2(){
        if (sin2 !=null){
            return sin2;
        }else {
            return sin2 = new sin();
        }
    }


}
