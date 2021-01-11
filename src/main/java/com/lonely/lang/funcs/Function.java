package com.lonely.lang.funcs;

/**
 * 项目名称：FunctionalProgramming-Util
 * 类 名 称：Function
 * 类 描 述：函数接口
 * 创建时间：2021/1/4 17:28 下午
 * 创 建 人：风中追风
 */
public interface Function<T, U> {

    /**
     * 执行方法
     *
     * @param t
     * @return
     */
    U apply(T t);


    /**
     * 将指定函数的值当做当前函数的入参，即先执行指定函数，再执行当前函数(this)
     *
     * @param before
     * @param <V>
     * @return
     */
    default <V> Function<V, U> compose(Function<V, T> before) {
        return (V v) -> this.apply(before.apply(v));
    }

    /**
     * 将当前函数的值当做指定函数的入参，即先执行当前函数，再执行指定入参函数
     *
     * @param after
     * @param <V>
     * @return
     */
    default <V> Function<T, V> andThen(Function<U, V> after) {
        return (T t) -> after.apply(this.apply(t));
    }


    /**
     * 恒等函数
     *
     * @param <T>
     * @return
     */
    static <T> Function<T, T> identity() {
        return (T t) -> t;
    }

    /**
     * 将参数2的结果用于参数1，即先执行参数2函数，在执行参数1函数
     *
     * @param after  后置函数
     * @param before 前置函数
     * @param <T>
     * @param <U>
     * @param <V>
     * @return
     */
    static <T, U, V> Function<T, V> compose(Function<U, V> after, Function<T, U> before) {
        return (T t) -> after.apply(before.apply(t));
    }

    /**
     * 将参数1的结果用于参数2，即先执行参数1，再执行参数2
     *
     * @param before 前置函数
     * @param after  后置函数
     * @param <T>
     * @param <U>
     * @param <V>
     * @return
     */
    static <T, U, V> Function<T, V> andThen(Function<T, U> before, Function<U, V> after) {
        return (T t) -> after.apply(before.apply(t));
    }


}
