package com.zaomianbao.algorithm.queue;

/**
 * @Description Queue
 * @Author zaomianbao
 * @Date 2020/3/24
 **/
public interface Queue<E> {

    /**
     * Inserts the specified element into this queue
     * @param e
     * @return true if the element was added to this queue, else false
     */
    boolean offer(E e);

    /**
     * Retrieves and removes the head of this queue,or returns null if this queue is empty
     * @return the head of this queue, or null if this queue is empty
     */
    E poll();

    /**
     * Retrieves, but does not remove, the head of this queue,or returns null if this queue is empty.
     * @return the head of this queue, or null if this queue is empty
     */
    E peek();

}
