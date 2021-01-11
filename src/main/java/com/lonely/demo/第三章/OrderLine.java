package com.lonely.demo.第三章;

/**
 * @author EDZ
 * @description: TODO
 * @date 2021/1/7 10:51
 */
public class OrderLine {


    private Product product;

    private int count;

    public OrderLine(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

    public OrderLine setProduct(Product product) {
        this.product = product;
        return this;
    }

    public OrderLine setCount(int count) {
        this.count = count;
        return this;
    }


    public double getWeight() {
        return this.product.getWeight() * count;
    }


    public double getAmount() {
        return this.product.getPrice() * count;
    }
}
