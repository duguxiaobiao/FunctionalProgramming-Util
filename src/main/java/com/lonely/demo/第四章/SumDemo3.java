package com.lonely.demo.第四章;

import com.lonely.lang.TailCall;

/**
 * @author EDZ
 * @description: TODO
 * @date 2021/1/7 11:54
 */
public class SumDemo3 {


    public static void main(String[] args) {

        System.out.println(add(3, 10));

    }

    public static int add(int x,int y ){
        return addRec(x,y).eval();
    }

    public static TailCall<Integer> addRec(int x, int y) {
        if (y == 0) {
            return new TailCall.Return<Integer>(x);
        } else {
            return new TailCall.Suspend<Integer>(() -> addRec(x + 1, y - 1));
        }
    }
}
