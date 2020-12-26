package com.zaomianbao.algorithm.stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * StackTest
 * @author zaomianbao
 * @date 2020/3/22
 **/
@Slf4j
public class StackTest {

    @Test
    public void testIsValidParentheses(){
        log.info(StackUtil.isValidParentheses("({}{()}[[]]({{{}}}))").toString());
    }

    @Test
    public void testDailyTemperatures(){
        int[] temperatures = {30, 19, 31, 20, 22, 39, 12, 40, 41, 42, 100, 3, 18};
        for (int i = 0; i < temperatures.length; i++) {
            log.info(temperatures[i]+"");
        }
        log.info("===");
        int[] result = StackUtil.dailyTemperatures(temperatures);
        for (int i = 0; i < result.length; i++) {
            log.info(result[i]+"");
        }
    }

    @Test
    public void testCalculateExpression(){
        String expression = "3*(5+2*(3*(3-1*2+1))+2)";
        log.info("计算结果为：{}",StackUtil.calculateExpression(expression));
    }

    @Test
    public void testLargestRectangleArea(){
        int[] heights = {7,7,1,5,6,2,3};
        log.info("直方图里最大的矩形区域面积为：{}",StackUtil.largestRectangleArea(heights));
    }

}
