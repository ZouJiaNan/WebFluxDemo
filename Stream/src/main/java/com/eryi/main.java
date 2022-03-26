package com.eryi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: ZouJiaNan
 * @date: 2022/3/24 10:28
 */
public class main {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        //map,中间操作，返回的是流
        //sum，中止操作，返回的是最终结果
        int sum= IntStream.of(nums).map(i->i*2).sum();
        System.out.println(sum);

        //从集合中创建
        List<String> list=new ArrayList<>();
        list.stream();
        list.parallelStream();
        //从数组创建
        Arrays.stream(new int[]{1,2,3});
        //创建数字流
        IntStream.of(1,2,3);
        //创建无限流(根据传入的参数，截取指定长度)
        new Random().ints().limit(10);

        int[] nums_1={1,2,3,4,5};
        Interface_01 interface_01=i->i*2;
        //拦截小于4的，然后X2,最后求和
        int sumNum=IntStream.of(nums_1).filter(i->i>4).map(interface_01::func).sum();
        System.out.println(sumNum);
        //并行流底层使用ForkJoinPool.commonPool线程池
        //默认线程数为当前机器的CPU数
        IntStream.range(1,100).parallel().peek(main::debug).count();

        ForkJoinPool forkJoinPool=new ForkJoinPool(100);
        forkJoinPool.submit(()->IntStream.range(1,100).parallel().peek(main::debug).count());
    }

    public static void debug(int i){
        System.out.println(Thread.currentThread().getName()+"------"+i);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
