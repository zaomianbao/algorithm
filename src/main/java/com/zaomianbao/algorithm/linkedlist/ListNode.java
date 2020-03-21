package com.zaomianbao.algorithm.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description ListNode
 * @Author zaomianbao
 * @Date 2020/3/21
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListNode<T> {

    private T value;
    private ListNode<T> next;

}
