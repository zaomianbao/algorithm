package com.zaomianbao.algorithm.util;

/**
 * @Description 全局自定义异常
 * @Author zaomianbao
 * @Date 2020/3/21
 **/
public class CommonException extends RuntimeException {

    private Integer code;

    public CommonException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode(){
        return this.code;
    }

}
