package com.lonely.demo.第一章;

import com.lonely.utils.Tuple;

/**
 * 项目名称：FunctionalProgramming-Util
 * 类 名 称：Donut
 * 类 描 述：甜甜圈
 * 创建时间：2020/12/2 11:05 下午
 * 创 建 人：macbook
 */
public class Donut {

    /**
     * 价格
     */
    public static double price = 2.0;


    /**
     * 购买甜甜圈
     * @param creditCard
     * @return
     */
    public static Donut buyDonut(CreditCard creditCard){

        Donut donut = new Donut();
        creditCard.charge(Donut.price);
        return donut;
    }


}
