package com.lonely.demo.第四章;

import com.lonely.lang.TailCall;
import com.lonely.lang.funcs.Function;

/**
 * @author EDZ
 * @description: TODO
 * @date 2021/1/7 11:54
 */
public class SumDemo4 {


    public static void main(String[] args) {

        System.out.println(add(3, 10));

    }


    static Function<Integer, Function<Integer, Integer>> add = x -> y -> {
        class AddHelper {
            Function<Integer, Function<Integer, TailCall<Integer>>> addHelper = a -> b -> b == 0 ?
                    TailCall.ret(a) :
                    TailCall.sus(() -> this.addHelper.apply(a + 1).apply(b - 1));

        }
        return new AddHelper().addHelper.apply(x).apply(y).eval();

    };


    public static int add(int x, int y) {
        return addRec(x, y).eval();
    }

    public static TailCall<Integer> addRec(int x, int y) {
        if (y == 0) {
            return new TailCall.Return<Integer>(x);
        } else {
            return new TailCall.Suspend<Integer>(() -> addRec(x + 1, y - 1));
        }
    }
}
