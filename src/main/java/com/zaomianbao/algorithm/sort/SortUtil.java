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
                    swap(t, j, j+1);
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
                    swap(t, i, j);
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
                swap(t, j-1, j);
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
                    swap(t, j-h, j);
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
     * 合并并排序两个有序数组(这里传入的数组即两个有序数组合并后的数组，但未被排序)
     * @param a     传入数组
     * @param lo    排序对比起始下标
     * @param mid   局部数组对比的边界，不一定是当前数组的中间下标
     * @param hi    排序对比结束下标
     * @return
     */
    public static void mergeSortedArray(Comparable[] a,int lo,int mid,int hi) {
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

    /**
     * 快速排序：先部分排序切分再进行子数组的递归调用
     * @param a
     * @param <T>
     */
    public static<T extends Comparable> void quickSort(T[] a,int lo,int hi) {
        if (hi <= lo) return;
        //处理枢纽值
        dealPivot(a,lo,hi);
        //部分排序后并切分返回切分点（这里的部分排序即为：a[lo..j-1] <= a[j] <= a[j+1..hi]）
        int j = partition(a, lo, hi);
        //递归调用左半部分完全排序
        quickSort(a,lo,j-1);
        //递归调用右半部分完全排序
        quickSort(a,j+1,hi);
    }

    /**
     * 处理枢纽值，将枢纽值放入数组头部
     * @param arr
     * @param left
     * @param right
     */
    private static<T extends Comparable> void dealPivot(T[] arr, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[left].compareTo(arr[right]) > 0) {
            swap(arr, left, right);
        }
        if (arr[left].compareTo(arr[mid]) > 0) {
            swap(arr, left, mid);
        }
        if (arr[right].compareTo(arr[mid]) < 0) {
            swap(arr, right, mid);
        }
        //枢纽值被放在序列头
        swap(arr, left, mid);
    }

    /**
     * 快速排序的切分
     * @param a
     * @param lo
     * @param hi
     * @param <T>
     * @return
     */
    private static<T extends Comparable> int partition(T[] a,int lo,int hi){
        int i = lo;
        int j = hi + 1;
        T v = a[lo];
        while (true) {
            //这里++i<=hi和--j>=lo条件还是有必要的，防止下标越界
            while (++i<=hi && a[i].compareTo(v) < 0);
            while (--j>=lo && v.compareTo(a[j]) < 0);
            //当i与j相遇后跳出循环
            if (i >= j) break;
            //交换i和j的元素，比头小的元素放到左边也就是i的位置，比头大的元素放到右边也就是j的位置
            swap(a, i, j);
        }
        // 左右两边各整理完后，将中间值，也就是头部的值与j位置的值进行交换
        // 这样就做到了中间值的左边都比中间值小，中间值的右边都比中间值大
        swap(a, lo, j);
        return j;
    }

    /**
     * 快速排序(三向切分的方式)
     * @param a
     * @param <T>
     */
    public static<T extends Comparable> void quickSort3Way(T[] a,int lo,int hi) {
        if (hi <= lo) return;
        //处理枢纽值
        dealPivot(a,lo,hi);
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        T v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) swap(a,lt++,i++);
            else if (cmp > 0) swap(a,i,gt--);
            else i++;
        }
        //递归调用左半部分完全排序
        quickSort3Way(a,lo,lt-1);
        //递归调用右半部分完全排序
        quickSort3Way(a,gt+1,hi);
    }

    /**
     * 元素交换
     * @param a
     * @param b
     * @param c
     * @param <T>
     */
    private static <T extends Comparable> void swap(T[] a, int b, int c) {
        T tmp = a[b];
        a[b] = a[c];
        a[c] = tmp;
    }

}
