package com.eryi;

/**
 * @description:
 * @author: ZouJiaNan
 * @date: 2022/3/23 18:28
 */
public class main {
    public static void main(String[] args) {
        Runnable target=new Runnable() {
            @Override
            public void run() {
                System.out.println("ok");
            }
        };
        target.run();
        
    }
}
