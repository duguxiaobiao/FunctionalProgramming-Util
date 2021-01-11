package com.lonely.demo.第四章;

import com.lonely.lang.TailCall;

/**
 * @author EDZ
 * @description: TODO
 * @date 2021/1/7 11:54
 */
public class SumDemo2 {


    public static void main(String[] args) {

        TailCall<Integer> tailCall = add(3, 10);
        while (tailCall.isSuspend()){
            tailCall = tailCall.resume();
        }
        System.out.println(tailCall.eval());
    }


    public static TailCall<Integer> add(int x, int y) {
        if (y == 0) {
            return new TailCall.Return<Integer>(x);
        } else {
            return new TailCall.Suspend<Integer>(() -> add(x + 1, y - 1));
        }
    }
}
