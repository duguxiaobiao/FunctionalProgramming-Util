package com.lonely.demo.第三章;

import com.lonely.lang.funcs.Function;

import java.util.Arrays;
import java.util.List;

/**
 * @author EDZ
 * @description: 折叠操作测试
 * @date 2021/1/5 15:46
 */
public class FlodDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Integer result = flod(list, 0, x -> y -> x + y);
        System.out.println(result);
    }

    public static Integer flod(List<Integer> list, Integer identity, Function<Integer,Function<Integer,Integer>> function){

        int result = identity;

        for (Integer curr : list) {
            result = function.apply(result).apply(curr);
        }
        return result;
    }

}
