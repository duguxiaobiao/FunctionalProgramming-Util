package com.lonely.lang;

import com.lonely.lang.funcs.Effect;

/**
 * 项目名称：FunctionalProgramming-Util
 * 类 名 称：Result
 * 类 描 述：针对处理结果对应的接口
 * 创建时间：2020/1/5 11:17 上午
 * 创 建 人：风中追风
 */
public interface Result<T> {

    /**
     * 绑定成功和异常的处理方式
     *
     * @param success
     * @param failure
     */
    void bind(Effect<T> success, Effect<String> failure);

    /**
     * 构造失败实体
     *
     * @param message
     * @param <T>
     * @return
     */
    public static <T> Result<T> failure(String message) {
        return new Result.Failure<>(message);
    }

    /**
     * 构造成功实体
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T t) {
        return new Result.Success<>(t);
    }


    /**
     * 结果--成功
     */
    public class Success<T> implements Result<T> {

        /**
         * 结果成功时需要的入参
         */
        private final T value;

        public Success(T value) {
            this.value = value;
        }

        /**
         * 绑定成功和异常的处理方式
         *
         * @param success
         * @param failure
         */
        @Override
        public void bind(Effect<T> success, Effect<String> failure) {
            success.apply(value);
        }
    }

    /**
     * 结果--失败
     */
    public class Failure<T> implements Result<T> {

        private final String errorMessage;

        public Failure(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        /**
         * 绑定成功和异常的处理方式
         *
         * @param success
         * @param failure
         */
        @Override
        public void bind(Effect<T> success, Effect<String> failure) {
            failure.apply(errorMessage);
        }
    }

}
