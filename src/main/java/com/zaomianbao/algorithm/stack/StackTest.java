package com.zaomianbao.algorithm.stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @Description StackTest
 * @Author zaomianbao
 * @Date 2020/3/22
 **/
@Slf4j
public class StackTest {

    @Test
    public void testIsValidParentheses(){
        log.info(StackUtil.isValidParentheses("({}{()}[[]]({{{}}}))").toString());
    }
}
