package com.lonely.demo.第三章;

import com.lonely.lang.CollectionUtilities;

import java.util.Arrays;
import java.util.List;

/**
 * @author EDZ
 * @description: map操作测试
 * @date 2021/1/5 16:48
 */
public class UnfoldDemo {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5);

        List<Integer> unfold = CollectionUtilities.unfold(1, x -> x + 1, x -> x < 8);
        System.out.println(unfold);

        List<Integer> range = CollectionUtilities.range(1, 10);
        System.out.println(range);

    }


}
