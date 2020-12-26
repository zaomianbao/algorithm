package com.zaomianbao.algorithm.queue;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * QueueTest
 * @author zaomianbao
 * @date 2020/3/24
 **/
@Slf4j
public class QueueTest {

    @Test
    public void testMaxSlidingWindow(){
        int[] array = {5, 16, 3, 1, 20, 9, 82, 7, 13, 1, 2};
        for (int i = 0; i < array.length; i++) {
            log.info(array[i]+"");
        }
        log.info("====");
        int[] result = LinkedDequeUtil.maxSlidingWindow(array, 3);
        for (int i = 0; i < result.length; i++) {
            log.info(result[i]+"");
        }
    }

}
