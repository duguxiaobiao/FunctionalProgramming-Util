package com.lonely.demo.第三章;

/**
 * @author EDZ
 * @description: TODO
 * @date 2021/1/7 10:49
 */
public class Product {


    private final String name;

    private final double price;

    private final double weight;

    public Product(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }
}
