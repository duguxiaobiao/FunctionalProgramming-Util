package com.lonely.demo.第三章;

import com.lonely.lang.CollectionUtilities;
import com.lonely.lang.funcs.Function;

import java.util.Arrays;
import java.util.List;

/**
 * @author EDZ
 * @description: 测试反转操作
 * @date 2021/1/5 15:46
 */
public class FlodDemo4 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        CollectionUtilities.reverse(list);
    }



}
