package com.zaomianbao.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description SortTest
 * @Author zaomianbao
 * @Date 2020/3/26
 **/
@Slf4j
public class SortTest {

    @Test
    public void testBubbleSort() {
        Integer[] t = {6,1,3,10,8,7,30,2,18,178,1,9,9,3};
        for (int i = 0; i < t.length; i++) {
            log.info("输入为：{}",t[i]);
        }
        log.info("====");
        Integer[] result = SortUtil.bubbleSort(t);
        for (int i = 0; i < result.length; i++) {
            log.info("输出为：{}",result[i]);
        }
    }

    @Test
    public void testSelectSort() {
        Integer[] t = {6,1,3,10,8,7,30,2,18,178,1,9,9,3};
        for (int i = 0; i < t.length; i++) {
            log.info("输入为：{}",t[i]);
        }
        log.info("====");
        Integer[] result = SortUtil.selectSort(t);
        for (int i = 0; i < result.length; i++) {
            log.info("输出为：{}",result[i]);
        }
    }

    @Test
    public void testInsertSort() {
        Integer[] t = {6,1,3,10,8,7,30,2,18,178,1,9,9,3};
        for (int i = 0; i < t.length; i++) {
            log.info("输入为：{}",t[i]);
        }
        log.info("====");
        Integer[] result = SortUtil.insertSort(t);
        for (int i = 0; i < result.length; i++) {
            log.info("输出为：{}",result[i]);
        }
    }

}
