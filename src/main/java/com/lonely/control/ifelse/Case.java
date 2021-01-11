package com.lonely.control.ifelse;

import com.lonely.lang.Result;
import com.lonely.lang.Tuple;
import com.lonely.lang.funcs.Supplier;

import java.util.Objects;

/**
 * 项目名称：FunctionalProgramming-Util
 * 类 名 称：Case
 * 类 描 述：if-else 判断条件实体
 * 创建时间：2020/1/5 14:18 下午
 * 创 建 人：风中追风
 */
public class Case<T> extends Tuple<Supplier<Boolean>, Supplier<Result<T>>> {


    public Case(Supplier<Boolean> condition, Supplier<Result<T>> value) {
        super(condition, value);
    }

    /**
     * 条件匹配
     *
     * @param condition 条件
     * @param value     条件匹配后的操作
     * @param <T>
     * @return
     */
    public static <T> Case<T> mcase(Supplier<Boolean> condition, Supplier<Result<T>> value) {
        return new Case<>(condition, value);
    }

    /**
     * 条件都不满足后的操作
     *
     * @param value
     * @param <T>
     * @return
     */
    public static <T> DefaultCase<T> defaultCase(Supplier<Result<T>> value) {
        return new DefaultCase<>(() -> true, value);
    }

    /**
     * 根据条件进行匹配返回最后的执行操作
     *
     * @param defaultCase else 操作
     * @param cases       根据条件判断操作
     * @param <T>
     * @return
     */
    @SafeVarargs
    public static <T> Result<T> match(DefaultCase<T> defaultCase, Case<T>... cases) {
        Objects.requireNonNull(cases);
        for (Case<T> aCase : cases) {
            if (aCase._1.get()) {
                return aCase._2.get();
            }
        }
        return defaultCase._2.get();
    }


    /**
     * 默认匹配项实体-----------例如 if ---- else if --- else 中的 else环节
     *
     * @param <T>
     */
    public static class DefaultCase<T> extends Case<T> {

        public DefaultCase(Supplier<Boolean> condition, Supplier<Result<T>> value) {
            super(condition, value);
        }
    }

}
