package com.lonely.lang.funcs;

/**
 * 项目名称：FunctionalProgramming-Util
 * 类 名 称：Effect
 * 类 描 述：有参无返回值函数接口
 * 创建时间：2020/1/5 11:17 上午
 * 创 建 人：风中追风
 */
public interface Effect<T> {

    /**
     * 执行
     *
     * @param t
     */
    void apply(T t);

}
