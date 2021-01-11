package com.lonely.demo.第一章;

import com.lonely.lang.Tuple;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：FunctionalProgramming-Util
 * 类 名 称：DonutShiop
 * 类 描 述：甜甜圈购买类
 * 创建时间：2020/12/2 11:28 下午
 * 创 建 人：macbook
 */
public class DonutShop {


    /**
     * 购买一个甜甜圈
     * @param creditCard
     * @return
     */
    public static Tuple<Donut,Payment> buyDonut(CreditCard creditCard){
        Donut donut = new Donut();
        Payment payment = new Payment(Donut.price, creditCard);
        return new Tuple<>(donut,payment);
    }

    /**
     * 购买多个甜甜圈
     * @param n
     * @param creditCard
     * @return
     */
    public static Tuple<List<Donut>,Payment> buyDonuts(int n,CreditCard creditCard){
        List<Donut> donuts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            donuts.add(new Donut());
        }

        return new Tuple<>(donuts,new Payment(Donut.price*n,creditCard));
    }

}
