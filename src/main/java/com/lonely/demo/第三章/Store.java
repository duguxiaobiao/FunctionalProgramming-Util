package com.lonely.demo.第三章;

import com.lonely.lang.CollectionUtilities;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EDZ
 * @description: TODO
 * @date 2021/1/7 10:53
 */
public class Store {


    public static void main(String[] args) {


        List<OrderLine> orderLines = new ArrayList<>();
        orderLines.add(new OrderLine(new Product("aaa",1.5,0.5),2));
        orderLines.add(new OrderLine(new Product("bbb",3.5,0.3),3));


        double weight = CollectionUtilities.foldLeft(orderLines, 0.0, x -> y -> x + y.getAmount());
        double amount = CollectionUtilities.foldLeft(orderLines,0.0,x->y->x+y.getWeight());

        System.out.println("weight:" + weight);
        System.out.println("amount:"+amount);

    }


}
