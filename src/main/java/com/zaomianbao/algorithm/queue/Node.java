package com.zaomianbao.algorithm.queue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description Node
 * @Author zaomianbao
 * @Date 2020/3/21
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node<E> {

    private E value;
    private Node<E> prev;
    private Node<E> next;

}
