package com.lonely.demo.第一章;

/**
 * 项目名称：FunctionalProgramming-Util
 * 类 名 称：Payment
 * 类 描 述：银行卡支付类
 * 创建时间：2020/12/2 11:09 下午
 * 创 建 人：macbook
 */
public class Payment {

    public double price;

    public CreditCard creditCard;

    public Payment(double price, CreditCard creditCard) {
        this.price = price;
        this.creditCard = creditCard;
    }

    /**
     * 合并支付
     *
     * @param payment
     * @return
     */
    public Payment combine(Payment payment) {
        if (this.creditCard.equals(payment.creditCard)) {
            return new Payment(this.price + payment.price, creditCard);
        } else {
            throw new IllegalStateException("cards don't match.");
        }
    }

}
