package com.lonely.demo.第三章;

import com.lonely.lang.CollectionUtilities;

import java.util.Arrays;
import java.util.List;

/**
 * @author EDZ
 * @description: map操作测试
 * @date 2021/1/5 16:48
 */
public class MapDemo {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3,4,5);

        List<Integer> result = CollectionUtilities.mapViaFoldLeft(list, x -> x + 1);
        System.out.println(result);

        List<Integer> result2 = CollectionUtilities.mapViaFoldRight(list, x -> x + 1);
        System.out.println(result2);

    }


}
