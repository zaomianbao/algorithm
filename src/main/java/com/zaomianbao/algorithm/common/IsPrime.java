package com.zaomianbao.algorithm.common;

import lombok.extern.slf4j.Slf4j;

/**
 * 判断一个数是否为素数
 * 注：质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数；否则称为合数（规定1既不是质数也不是合数）
 *
 * @author zaomianbao
 * @date 2020/12/30
 **/
@Slf4j
public class IsPrime {

    private static boolean isPrimeFunction1(int param) {
        if (param < 2) {
            return false;
        }
        if (param == 2) {
            return true;
        }
        for (int i = 2; i < param; i++) {
            if (param % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrimeFunction2(int param) {
        if (param < 2) {
            return false;
        }
        if (param == 2) {
            return true;
        }
        int sqrt = (int)Math.sqrt(param);
        for (int i = 2; i <= sqrt; i++) {
            if (param % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrimeFunction3(int param) {
        if (param < 2) {
            return false;
        }
        if (param == 2) {
            return true;
        }
        if (param % 6 != 1 && param % 6 != 5) {
            return false;
        }
        log.info("进一步判断");
        int sqrt = (int)Math.sqrt(param);
        for (int i = 2; i <= sqrt; i++) {
            if (param % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        log.info("是否为素数1:{}",isPrimeFunction1(73));
        log.info("是否为素数2:{}",isPrimeFunction2(73));
        log.info("是否为素数3:{}",isPrimeFunction3(73));
    }

}
