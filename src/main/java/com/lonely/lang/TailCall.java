package com.lonely.lang;

import com.lonely.lang.funcs.Supplier;

/**
 * 项目名称：FunctionalProgramming-Util
 * 类 名 称：TailCall
 * 类 描 述：尾部调用
 * 创建时间：2020/1/5 11:17 上午
 * 创 建 人：风中追风
 */
public abstract class TailCall<T> {

    /**
     * 返回下一个调用
     *
     * @return
     */
    public abstract TailCall<T> resume();

    /**
     * 执行递归计算，返回最终的结果
     *
     * @return
     */
    public abstract T eval();

    /**
     * 返回当前对象是 Return 还是 Suspend
     *
     * @return
     */
    public abstract boolean isSuspend();

    /**
     * 构建计算结果对象
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> Return<T> ret(T t) {
        return new Return<>(t);
    }

    /**
     * 构建中间对象
     *
     * @param resume
     * @param <T>
     * @return
     */
    public static <T> Suspend<T> sus(Supplier<TailCall<T>> resume) {
        return new Suspend<>(resume);
    }


    /**
     * 尾部返回
     *
     * @param <T>
     */
    public static class Return<T> extends TailCall<T> {

        private final T t;

        public Return(T t) {
            this.t = t;
        }


        /**
         * 返回下一个调用
         *
         * @return
         */
        @Override
        public TailCall<T> resume() {
            throw new IllegalStateException("Return has no resume");
        }

        /**
         * 执行递归计算，返回最终的结果
         *
         * @return
         */
        @Override
        public T eval() {
            return t;
        }

        /**
         * 返回当前对象是 Return 还是 Suspend
         *
         * @return
         */
        @Override
        public boolean isSuspend() {
            return false;
        }
    }

    /**
     * 中间递归处理
     *
     * @param <T>
     */
    public static class Suspend<T> extends TailCall<T> {

        /**
         * 下一个递归过程
         */
        private final Supplier<TailCall<T>> resume;

        public Suspend(Supplier<TailCall<T>> resume) {
            this.resume = resume;
        }

        /**
         * 返回下一个调用
         *
         * @return
         */
        @Override
        public TailCall<T> resume() {
            return resume.get();
        }

        /**
         * 执行递归计算，返回最终的结果
         *
         * @return
         */
        @Override
        public T eval() {
            //throw new IllegalStateException("Suspend has no value");

            TailCall<T> tailCall = this;
            while (tailCall.isSuspend()) {
                tailCall = tailCall.resume();
            }
            return tailCall.eval();
        }

        /**
         * 返回当前对象是 Return 还是 Suspend
         *
         * @return
         */
        @Override
        public boolean isSuspend() {
            return true;
        }
    }

}
