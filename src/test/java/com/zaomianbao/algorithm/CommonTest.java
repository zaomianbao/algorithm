package com.zaomianbao.algorithm;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 公共测试类
 *
 * @author zaomianbao
 * @date 2020/12/26
 **/
@Slf4j
public class CommonTest {

    @Test
    public void testMath() {
        //可以看出Math中的sin方法传入的角度值为弧度，即π/6，而不是30°，但是可以通过方法进行角度到弧度的转换
        log.info("sin:{}",Math.sin(Math.PI/2));
        //角度转弧度
        log.info("角度转弧度:{}",Math.toRadians(180));
        //弧度转角度
        log.info("弧度转角度:{}",Math.toDegrees(Math.PI/2));
        //tan90°时得到的不是无穷大，因为这里的PI是近似值，所以得到的值是一个很大的数而不是无穷大
        log.info("tan:{}",Math.tan(Math.PI/2));
        //e¹
        log.info("指数函数:{}",Math.exp(1));
        //㏒e¹
        log.info("对数函数:{}",Math.log(1));
        //2¹
        log.info("次方函数:{}",Math.pow(2,1));
        //√4
        log.info("平方根函数:{}",Math.sqrt(4));
    }

}
