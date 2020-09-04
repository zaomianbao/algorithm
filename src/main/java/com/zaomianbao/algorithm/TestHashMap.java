package com.zaomianbao.algorithm;

import com.zaomianbao.algorithm.util.RandomFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TestHashMap
 * @Author zaomianbao
 * @Date 2020/3/23
 **/
public class TestHashMap {

    public static void main(String[] args) {

        Map<Integer,Integer> map = new HashMap<Integer,Integer>(64,0.99f);
        for (int i = 64; i < 1000000; i = i*2) {
            map.put(i,RandomFactory.RANDOM.getRandom().nextInt(2000000));
        }
    }

}
