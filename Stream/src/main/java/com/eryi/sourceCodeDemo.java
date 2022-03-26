package com.eryi;

import java.util.stream.IntStream;

/**
 * @description:
 * @author: ZouJiaNan
 * @date: 2022/3/24 13:46
 */
public class sourceCodeDemo {
    public static void main(String[] args) {
        IntStream.range(1,100)
                .peek(i-> System.out.println("peek---"+i))
                .filter(i->
                {
                    System.out.println("filter---"+i);
                    return true;})
        .count();
    }
}
