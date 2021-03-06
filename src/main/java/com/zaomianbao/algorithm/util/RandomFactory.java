package com.zaomianbao.algorithm.util;

import java.util.Random;

/**
 * 随机类工厂
 * @author zaomianbao
 * @date 2020/3/21
 **/
public enum RandomFactory {

    RANDOM;

    private Random random;

    RandomFactory(){
        random = new Random();
    }

    public Random getRandom(){
        return random;
    }

}
