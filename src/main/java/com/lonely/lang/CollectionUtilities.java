package com.lonely.lang;

import com.lonely.lang.funcs.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 项目名称：FunctionalProgramming-Util
 * 类 名 称：CollectionUtilities
 * 类 描 述：集合操作类库
 * 创建时间：2020/1/5 14:48 下午
 * 创 建 人：风中追风
 */
public class CollectionUtilities {

    public static void main(String[] args) {

        String a = 'a' + ('b' + ('c' + ""));
        System.out.println(a);
    }

    /**
     * 返回一个不可变的空集合
     *
     * @param <T>
     * @return
     */
    public static <T> List<T> list() {
        return Collections.emptyList();
    }

    /**
     * 将传入的参数构建一个不可变的单值列表
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> List<T> list(T t) {
        return Collections.singletonList(t);
    }


    /**
     * 将传入的集合转换成一个不可变的列表
     *
     * @param ts
     * @param <T>
     * @return
     */
    public static <T> List<T> list(List<T> ts) {
        return Collections.unmodifiableList(new ArrayList<>(ts));
    }

    /**
     * 将传入的数组转换成一个不可变的列表
     *
     * @param ts
     * @param <T>
     * @return
     */
    @SafeVarargs
    public static <T> List<T> list(T... ts) {
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(ts, ts.length)));
    }

    /**
     * 返回集合中的头数据
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> T head(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalStateException("head of empty list");
        }
        return list.get(0);
    }

    /**
     * 移除集合中第一个参数，返回剩余的集合
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> tail(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalStateException("tail of empty list");
        }

        List<T> copy = copy(list);
        copy.remove(0);
        return list(copy);
    }


    /**
     * 在原有的集合后面追加指定元素，返回一个新的集合
     *
     * @param list 待操作集合
     * @param t    待添加的元素
     * @param <T>
     * @return 新集合
     */
    public static <T> List<T> append(List<T> list, T t) {
        List<T> copy = copy(list);
        copy.add(t);
        return list(copy);
    }

    /**
     * 在原有的集合最前面插入指定元素，返回一个新的集合
     *
     * @param list 待操作集合
     * @param t    待插入的元素
     * @param <T>
     * @return
     */
    public static <T> List<T> prepend(List<T> list, T t) {
        //命令版本
        /*List<T> copy = copy(list);
        copy.add(0, t);
        return list(copy);*/

        //函数式接口版本
        return foldLeft(list, list(t), x -> y -> append(x, y));
    }


    /**
     * 集合左折叠操作(反向递归)
     *
     * @param list     待操作的集合
     * @param identity 中性值，初始值
     * @param function 折叠操作
     * @param <T>
     * @param <U>
     * @return
     */
    public static <T, U> U foldLeft(List<T> list, U identity, Function<U, Function<T, U>> function) {

        U result = identity;

        for (T current : list) {
            result = function.apply(result).apply(current);
        }

        return result;
    }


    /**
     * 集合右折叠操作(正向递归)
     *
     * @param list
     * @param identity
     * @param function
     * @param <T>
     * @param <U>
     * @return
     */
    public static <T, U> U foldRight(List<T> list, U identity, Function<T, Function<U, U>> function) {
        //非递归版本
        /*U result = identity;
        for (int i = list.size() - 1; i >= 0; i--) {
            result = function.apply(list.get(i)).apply(result);
        }
        return result;*/

        //递归版本
        return list.isEmpty() ? identity : function.apply(head(list)).apply(foldRight(tail(list), identity, function));
    }

    /**
     * 集合反转
     *
     * @param list
     * @param <T>
     */
    public static <T> void reverse(List<T> list) {
        List<T> result = new ArrayList<>();
        //Function<List<T>, Function<T, List<T>>> function = x -> y -> prepend(x,y);
        Function<List<T>, Function<T, List<T>>> function = x -> y -> foldLeft(x, list(y), a -> b -> append(a, b));
        List<T> result1 = foldLeft(list, result, function);
        System.out.println(result1);
    }


    /**
     * 将指定集合中的每个元素做Map操作，即循环集合中的每个元素，将每个元素进行指定传入的动作后，返回一个新的集合(使用左折叠实现)
     *
     * @param list
     * @param function
     * @param <T>
     * @param <U>
     * @return
     */
    public static <T, U> List<U> mapViaFoldLeft(List<T> list, Function<T, U> function) {
        return foldLeft(list, list(), x -> y -> append(x, function.apply(y)));
    }

    /**
     * 将指定集合中的每个元素做Map操作，即循环集合中的每个元素，将每个元素进行指定传入的动作后，返回一个新的集合(使用右折叠实现)
     *
     * @param list
     * @param function
     * @param <T>
     * @param <U>
     * @return
     */
    public static <T, U> List<U> mapViaFoldRight(List<T> list, Function<T, U> function) {
        return foldRight(list, list(), x -> y -> prepend(y, function.apply(x)));
    }


    public static <T> List<T> unfold(T t, Function<T, T> f, Function<T, Boolean> p) {
        List<T> result = list();
        T temp = t;
        while (p.apply(temp)) {
            result = append(result, temp);
            temp = f.apply(temp);
        }
        return result;
    }


    /**
     *
     * @param start
     * @param end
     * @return
     */
    public static List<Integer> range(int start, int end) {
        //
        //return unfold(start, x -> x + 1, x -> x < end);

        //递归版本
        return start >= end ? list() : prepend(range(start, start + 1), end);

    }


    /**
     * copy集合,不影响原来的集合数据
     *
     * @param list
     * @param <T>
     * @return
     */
    private static <T> List<T> copy(List<T> list) {
        return new ArrayList<>(list);
    }


}
