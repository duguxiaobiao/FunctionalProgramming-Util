package com.lonely.demo.第三章;

import com.lonely.lang.CollectionUtilities;
import com.lonely.lang.funcs.Function;

import java.util.Arrays;
import java.util.List;

/**
 * @author EDZ
 * @description: 右折叠操作测试---测试字符串
 * @date 2021/1/5 15:46
 */
public class FlodDemo3 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Function<Integer,Function<String,String>> function = x ->y -> addIS(x, y);
        String result = CollectionUtilities.foldRight(list, "0",function );
        System.out.println(result);
    }

    private static String addIS(Integer i,String s) {
        return "(" + i + "+" + s + ")";
    }


}
