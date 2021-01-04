package com.zaomianbao.algorithm.common;

import lombok.extern.slf4j.Slf4j;

/**
 * 数学相关算法
 *
 * @author zaomianbao
 * @date 2020/12/30
 **/
@Slf4j
public class MathAlgorithm {

    private MathAlgorithm() {throw new IllegalStateException("Utility class");}

    /**
     * 判断一个数是否为素数
     * @param param
     * @return
     */
    public static boolean isPrime(int param) {
        if (param < 2) {
            return false;
        }
        if (param == 2) {
            return true;
        }
        if (param % 6 != 1 && param % 6 != 5) {
            return false;
        }
        int sqrt = (int)Math.sqrt(param);
        for (int i = 2; i <= sqrt; i++) {
            if (param % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 求一个数的开平方
     * @param param
     * @return
     */
    public static double sqrt(double param) {
        if (param < 0) {
            return Double.NaN;
        }
        //这里的是近似值的精度
        double accuracy = 1e-15;
        double x = param;
        double y = (x + param / x) / 2;
        while (Math.abs(x - y) > accuracy) {
            x = y;
            y = (x + param / x) / 2;
        }
        return x;
    }

}
