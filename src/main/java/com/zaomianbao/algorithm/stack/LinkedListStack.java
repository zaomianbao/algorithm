package com.zaomianbao.algorithm.stack;

import com.zaomianbao.algorithm.linkedlist.Node;

/**
 * LinkedListStack
 * @author zaomianbao
 * @date 2020/3/22
 **/
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
        newHead.setNext(this.head);
        this.head = newHead;
        return item;
    }

    /**
     * 出栈
     * @return
     */
    public E pop() {
        Node<E> node = this.head;
        if (node == null) {
            return null;
        }
        E value = node.getValue();
        this.head = node.getNext();
        return value;
    }

    /**
     * 观察栈顶元素
     * @return
     */
    public E peek() {
        Node<E> node = this.head;
        if (node == null) {
            return null;
        }
        return node.getValue();
    }
}
