package com.lonely.demo.第四章;

/**
 * @author EDZ
 * @description: TODO
 * @date 2021/1/7 11:54
 */
public class SumDemo1 {


    public static void main(String[] args) {

        System.out.println(add(0, 5));
        System.out.println(addRec(0, 5));


    }


    static int add(int x, int y) {
        while (y > 0) {
            x++;
            y--;
        }
        return x;
    }

    static int addRec(int x,int y){
        if(y<=0){
            return x;
        }
        x++;
        y--;
        return addRec(x,y);
    }

}
