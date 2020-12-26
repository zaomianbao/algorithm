package com.zaomianbao.algorithm.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Node
 * @author zaomianbao
 * @date 2020/3/21
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Node<T> {

    private T value;
    private Node<T> next;

}
