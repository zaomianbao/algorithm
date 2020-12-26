package com.zaomianbao.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * SortTest
 * @author zaomianbao
 * @date 2020/3/26
 **/
@Slf4j
public class SortTest {

    @Test
    public void testBubbleSort() {
        Integer[] t = {6,1,3,10,8,7,30,2,18,178,1,9,9,3};
        for (int i = 0; i < t.length; i++) {
            printIn(t[i]);
        }
        log.info("====");
        Integer[] result = SortUtil.bubbleSort(t);
        for (int i = 0; i < result.length; i++) {
            printOut(result[i]);
        }
    }

    @Test
    public void testSelectSort() {
        Integer[] t = {6,1,3,10,8,7,30,2,18,178,1,9,9,3};
        for (int i = 0; i < t.length; i++) {
            printIn(t[i]);
        }
        log.info("====");
        Integer[] result = SortUtil.selectSort(t);
        for (int i = 0; i < result.length; i++) {
            printOut(result[i]);
        }
    }

    @Test
    public void testInsertSort() {
        Integer[] t = {6,1,3,10,8,7,30,2,18,178,1,9,9,3};
        for (int i = 0; i < t.length; i++) {
            printIn(t[i]);
        }
        log.info("====");
        Integer[] result = SortUtil.insertSort(t);
        for (int i = 0; i < result.length; i++) {
            printOut(result[i]);
        }
    }

    @Test
    public void testShellSort() {
        Integer[] t = {6,1,3,10,8,7,30,2,18,17,1,9,9,3};
        for (int i = 0; i < t.length; i++) {
            printIn(t[i]);
        }
        log.info("====");
        Integer[] result = SortUtil.shellSort(t);
        for (int i = 0; i < result.length; i++) {
            printOut(result[i]);
        }
    }

    @Test
    public void testMergeSortArray(){
        Integer[] t1 = {1,3,10,18,27,30,31,34,44};
        Integer[] t2 = {20,29,39,43};
        Integer[] t = new Integer[t1.length+t2.length];
        for (int i = 0; i < t.length; i++) {
            if (i < t1.length) {
                t[i] = t1[i];
            } else {
                t[i] = t2[i - t1.length];
            }
            printIn(t[i]);
        }
        log.info("====");
        SortUtil.mergeSortedArray(t,0,t1.length-1,t.length-1);
        for (int i = 0; i < t.length; i++) {
            log.info("输出为：{}",t[i]);
        }
    }

    @Test
    public void testMergeSortTopDown() {
        Integer[] t = {6,1,3,10,8,7,30,2,18,17,1,9,9,3};
        for (int i = 0; i < t.length; i++) {
            printIn(t[i]);
        }
        log.info("====");
        Comparable[] result = SortUtil.mergeSortTopDown(t);
        for (int i = 0; i < result.length; i++) {
            printOut(result[i]);
        }
    }

    @Test
    public void testMergeSortBottomUp() {
        Integer[] t = {6,1,3,10,8,7,30,2,18,17,1,9,9,3};
        for (int i = 0; i < t.length; i++) {
            printIn(t[i]);
        }
        log.info("====");
        SortUtil.mergeSortBottomUp(t);
        for (int i = 0; i < t.length; i++) {
            printOut(t[i]);
        }
    }

    @Test
    public void testQuickSort() {
        Integer[] t = {6,1,3,10,8,7,30,2,18,17,1,9,9,3};
        for (int i = 0; i < t.length; i++) {
            printIn(t[i]);
        }
        log.info("====");
        SortUtil.quickSort(t,0,t.length-1);
        for (int i = 0; i < t.length; i++) {
            printOut(t[i]);
        }
    }

    @Test
    public void testQuickSort3Way() {
        Integer[] t = {6,1,3,10,3,3,1,8,10,1,6,6,3,10};
        for (int i = 0; i < t.length; i++) {
            printIn(t[i]);
        }
        log.info("====");
        SortUtil.quickSort3Way(t,0,t.length-1);
        for (int i = 0; i < t.length; i++) {
            printOut(t[i]);
        }
    }

    private static<T> void printIn(T o) {
        log.info("输入为：{}", o);
    }

    private static<T> void printOut(T o) {
        log.info("输出为：{}", o);
    }


}
