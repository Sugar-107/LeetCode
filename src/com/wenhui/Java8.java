package com.wenhui;

import org.junit.Test;

import java.util.Optional;

/**
 * java8 的操作类
 * 1.0 java8 optional java
 * @author 程文辉
 */
public class Java8 {



    @Test
    public void testOptional(){
        Optional<String> optional = Optional.of("wola");

        optional.ifPresent(s -> {
            System.out.println("s = " + s);
        });

        System.out.println(optional.orElseGet(()->"hello"));

    }
}
