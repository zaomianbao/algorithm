package com.zaomianbao.algorithm.queue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * LinkedDeque
 * @author zaomianbao
 * @date 2020/3/24
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkedDeque<E> implements Deque<E> {

    private Node<E> first;

    private Node<E> last;

    public boolean offerFirst(E e) {
        if (e == null) {
            return false;
        }
        Node<E> newHead = new Node<E>();
        newHead.setValue(e);
        Node<E> oldHead = this.first;
        if (oldHead != null) {
            newHead.setNext(first);
            oldHead.setPrev(newHead);
        }
        this.first = newHead;
        return true;
    }

    public boolean offerLast(E e) {
        if (e == null) {
            return false;
        }
        Node<E> newRear = new Node<E>();
        newRear.setValue(e);
        Node<E> oldRear = this.last;
        if (oldRear != null) {
            newRear.setPrev(oldRear);
            oldRear.setNext(newRear);
        } else {
            this.last = newRear;
            this.first = newRear;
        }
        return true;
    }

    public E pollFirst() {
        Node<E> head = this.first;
        if (head == null) {
            return null;
        }
        Node<E> next = head.getNext();
        head.setNext(null);
        if (next != null) {
            next.setPrev(null);
        }else {
            this.last = null;
        }
        this.first = next;
        return head.getValue();
    }

    public E pollLast() {
        Node<E> rear = this.last;
        if (rear == null) {
            return null;
        }
        Node<E> prev = rear.getPrev();
        rear.setPrev(null);
        if (prev != null) {
            prev.setNext(null);
        }else {
            this.first = null;
        }
        this.last = prev;
        return rear.getValue();
    }

    public E peekFirst() {
        Node<E> head = this.first;
        if (head == null) {
            return null;
        }
        return head.getValue();
    }

    public E peekLast() {
        Node<E> rear = this.last;
        if (rear == null) {
            return null;
        }
        return rear.getValue();
    }

}
