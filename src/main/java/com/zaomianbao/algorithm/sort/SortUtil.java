package com.zaomianbao.algorithm.sort;

import com.zaomianbao.algorithm.util.CommonException;

/**
 * @Description SortUtil
 * @Author zaomianbao
 * @Date 2020/3/26
 **/
public class SortUtil {

    private SortUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 冒泡排序，依次将最大值沉入海底（当一座城沉入海底当一个人成了谜）
     * @param t
     * @param <T>
     * @return
     */
    public static<T extends Comparable> T[] bubbleSort(T[] t){
        if (t == null) {
            throw new CommonException(-1,"非法参数");
        }
        int length = t.length;
        if (length == 1) {
            return t;
        }
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            //每次循环的长度减一，因为每次都有一个最大值沉到了最底下，剩下只需要对上层未处理的数据进行循环
            for (int j = 0; j < length - i - 1; j++) {
                if (t[j].compareTo(t[j+1]) > 0 ) {
                    T tmp = t[j];
                    t[j] = t[j+1];
                    t[j+1] = tmp;
                    flag = true;
                }
            }
            //优化点，当发现经过一次完整的内部循环后，flag已经未变，
            //则代表剩余的数组元素已然有序，再加上之前沉入底部的元素，则一起构成了一个完整的顺序集合
            //此时直接跳出排序
            if (!flag) {
                break;
            }

        }
        return t;
    }

    /**
     * 选择排序
     * @param t
     * @param <T>
     * @return
     */
    public static<T extends Comparable> T[] selectSort(T[] t) {
        if (t == null) {
            throw new CommonException(-1,"非法参数");
        }
        int length = t.length;
        if (length == 1) {
            return t;
        }
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            //每次循环的起点下标会增一，因为每次都有一个最小值被选择进入到了最头部，剩下只需要对下层层未处理的数据进行循环
            for (int j = i + 1 ; j < length; j++) {
                if (t[i].compareTo(t[j]) > 0) {
                    T tmp = t[i];
                    t[i] = t[j];
                    t[j] = tmp;
                    flag = true;
                }
            }
            //优化点，当发现经过一次完整的内部循环后，flag已经未变，
            //则代表剩余的数组元素已然有序，再加上之前选择进入头部的元素，则一起构成了一个完整的顺序集合
            //此时直接跳出排序
            if (!flag) {
                break;
            }
        }
        return t;
    }

    /**
     * 插入排序
     * @param t
     * @param <T>
     * @return
     */
    public static<T extends Comparable> T[] insertSort(T[] t) {
        if (t == null) {
            throw new CommonException(-1,"非法参数");
        }
        int length = t.length;
        if (length == 1) {
            return t;
        }
        for (int i = 0; i < length; i++) {
            //每次只比较当前下标与之前元素的大小
            //将当前元素与之前的元素一一对比，直至插入到正确大小顺序的位置停止
            //(即不一定会遍历到头就可以跳出了，因为顺序已经是排序的)
            for (int j = i; j > 0 && t[j].compareTo(t[j-1]) < 0; j--) {
                T tmp = t[j];
                t[j] = t[j-1];
                t[j-1] = tmp;
            }
        }
        return t;
    }
}
