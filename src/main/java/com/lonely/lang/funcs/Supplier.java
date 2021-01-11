package com.lonely.lang.funcs;

/**
 * 项目名称：FunctionalProgramming-Util
 * 类 名 称：Supplier
 * 类 描 述：无参有返回值函数接口
 * 创建时间：2020/1/5 14:18 下午
 * 创 建 人：风中追风
 */
public interface Supplier<T> {

    /**
     * 获取结果
     *
     * @return
     */
    T get();
}
