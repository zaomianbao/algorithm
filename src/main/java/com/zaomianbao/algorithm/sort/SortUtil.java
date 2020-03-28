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
     * 辅助数组
     */
    private static Comparable[] aux;

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
     * 选择排序，一次将最小值提到数组头部
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

    /**
     * 希尔排序(插入排序的优化版本)
     * @param t
     * @param <T>
     * @return
     */
    public static<T extends Comparable> T[] shellSort(T[] t) {
        int length = t.length;
        int h = 1;
        while (h < length/3) {
            //递增序列(这个递增序列并不是最好的，但是是最简单和通用的，更加优秀的递增序列有待我们发现)
            h = 3 * h + 1;
        }
        //递增序列的最大值决定了循环的次数，即将大数组拆分成不同级别的次数；当h递归到0时退出循环
        while (h >= 1) {
            //内层即为普通的插入排序，只不过这里的起点下标为h，同时是相邻h个元素的值进行比较和交换
            for (int i = h; i < length ; i++) {
                for (int j = i; j >= h && t[j].compareTo(t[j - h]) < 0; j = j - h) {
                    T tmp = t[j];
                    t[j] = t[j-h];
                    t[j-h] = tmp;
                }
            }
            //递增序列逐渐递归为1
            h = h/3;
        }
        return t;
    }

    /**
     * 归并排序（自顶向下方式，递归的方式）
     * @param a
     * @return
     */
    public static Comparable[] mergeSortTopDown(Comparable[] a){
        int length = a.length;
        //辅助数组
        aux = new Comparable[length];
        sort(a,0, length -1);
        return a;
    }

    /**
     * 归并排序（自底向上方式，非递归循序渐进的方式）
     * @param a
     * @return
     */
    public static void mergeSortBottomUp(Comparable[] a){
        int length = a.length;
        //辅助数组
        aux = new Comparable[length];
        for (int size = 1; size < length; size=size+size) {
            for (int lo = 0; lo < length - size; lo += size + size) {
                mergeSortedArray(a,lo,lo+size-1,Math.min(lo+size+size-1,length-1));
            }
        }
    }

    /**
     * 递归拆分排序加合并
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a,int lo,int hi){
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/ 2;
        sort(a,lo,mid);
        sort(a,mid + 1,hi);
        mergeSortedArray(a,lo,mid,hi);
    }

    /**
     * 合并并排序两个有序数组(这里传入的数组即两个有序数组合并后的数组，但未被排序)
     * @param a     传入数组
     * @param lo    排序对比起始下标
     * @param mid   局部数组对比的边界，不一定是当前数组的中间下标
     * @param hi    排序对比结束下标
     * @return
     */
    private static void mergeSortedArray(Comparable[] a,int lo,int mid,int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if ((aux[j]).compareTo(aux[i]) < 0) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

}
