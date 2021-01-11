package com.lonely.demo.第三章;

import com.lonely.lang.CollectionUtilities;
import com.lonely.lang.funcs.Function;

import java.util.Arrays;
import java.util.List;

/**
 * @author EDZ
 * @description: 折叠操作测试---测试字符串
 * @date 2021/1/5 15:46
 */
public class FlodDemo2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        String result = CollectionUtilities.foldLeft(list, "0", x -> y -> addSI(x, y));
        System.out.println(result);
    }

    private static String addSI(String s, Integer i) {
        return "(" + s + "+" + i + ")";
    }


}
