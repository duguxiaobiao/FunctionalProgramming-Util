package com.lonely.utils;

/**
 * 项目名称：FunctionalProgramming-Util
 * 类 名 称：Tuple
 * 类 描 述：元组通用类
 * 创建时间：2020/12/2 11:17 下午
 * 创 建 人：macbook
 */
public class Tuple<T,U> {


    public final T _1;

    public final U _2;

    public Tuple(T _1, U _2) {
        this._1 = _1;
        this._2 = _2;
    }
}
