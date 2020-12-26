package com.zaomianbao.algorithm.queue;

/**
 * Deque
 * @author zaomianbao
 * @date 2020/3/24
 **/
public interface Deque<E>{

    /**
     * Inserts the specified element at the front of this deque
     * @param e the element to add
     * @return true if the element was added to this deque, else false
     */
    boolean offerFirst(E e);

    /**
     * Inserts the specified element at the end of this deque
     * @param e the element to add
     * @return true if the element was added to this deque, else false
     */
    boolean offerLast(E e);

    /**
     * Retrieves and removes the first element of this deque,or returns null if this deque is empty.
     *
     * @return the head of this deque, or null if this deque is empty
     */
    E pollFirst();

    /**
     * Retrieves and removes the last element of this deque,or returns null if this deque is empty.
     *
     * @return the tail of this deque, or null if this deque is empty
     */
    E pollLast();

    /**
     * Retrieves, but does not remove, the first element of this deque,or returns null if this deque is empty.
     *
     * @return the head of this deque, or null if this deque is empty
     */
    E peekFirst();

    /**
     * Retrieves, but does not remove, the last element of this deque,or returns null if this deque is empty.
     *
     * @return the tail of this deque, or null if this deque is empty
     */
    E peekLast();

}
