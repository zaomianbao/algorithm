package com.zaomianbao.algorithm.stack;

/**
 * @Description Stack
 * @Author zaomianbao
 * @Date 2020/3/22
 **/
public interface Stack<E> {

    /**
     * 压入至栈顶
     * @param item
     * @return
     */
    E push(E item);

    /**
     * 弹出栈顶元素
     * @return
     */
    E pop();

    /**
     * 瞥一眼栈顶元素
     * @return
     */
    E peek();

}
