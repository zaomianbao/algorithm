package com.zaomianbao.algorithm.stack;

import com.zaomianbao.algorithm.linkedlist.Node;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description LinkedListStack
 * @Author zaomianbao
 * @Date 2020/3/22
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkedListStack<E> implements Stack<E>{

    private Node<E> head;

    /**
     * 入栈
     * @param item
     * @return
     */
    public E push(E item) {
        if (item == null) {
            return null;
        }
        Node<E> newHead = new Node<E>();
        newHead.setValue(item);
        newHead.setNext(getHead());
        setHead(newHead);
        return item;
    }

    /**
     * 出栈
     * @return
     */
    public E pop() {
        Node<E> node = getHead();
        if (node == null) {
            return null;
        }
        E value = node.getValue();
        setHead(node.getNext());
        return value;
    }

    /**
     * 观察栈顶元素
     * @return
     */
    public E peek() {
        Node<E> node = getHead();
        if (node == null) {
            return null;
        }
        return node.getValue();
    }
}
