package com.lonely;

import com.lonely.demo.第一章.CreditCard;
import com.lonely.demo.第一章.Donut;
import com.lonely.demo.第一章.DonutShop;
import com.lonely.demo.第一章.Payment;
import com.lonely.lang.Tuple;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * 项目名称：FunctionalProgramming-Util
 * 类 名 称：第一章
 * 类 描 述：TODO
 * 创建时间：2020/12/2 11:34 下午
 * 创 建 人：macbook
 */
public class 第一章 {

    @Test
    public void testBuyDonuts(){
        CreditCard creditCard = new CreditCard();

        Tuple<List<Donut>, Payment> tuple = DonutShop.buyDonuts(5,creditCard);
        assertEquals(Donut.price*5,tuple._2.price,0);
    }

}
