package com.zaomianbao.algorithm.linkedlist;

import com.zaomianbao.algorithm.util.RandomFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.util.Random;

/**
 * 链表结构JUNIT测试类
 * @author zaomianbao
 * @date 2020/3/21
 **/
@Slf4j
public class LinkedListTest {

    /**
     * 随机构造一个指定长度的链表结构
     * @param range
     * @return
     */
    private Node<Integer> randomIntLinkedList(int range) {
        Random random = RandomFactory.RANDOM.getRandom();
        Node<Integer> head = new Node<Integer>(random.nextInt(20), null);
        Node<Integer> curr = head;
        Node<Integer> next;
        for (int i = 1; i < range; i++) {
            next = new Node<Integer>(random.nextInt(20), null);
            curr.setNext(next);
            curr = next;
        }
        logLinkedList(head);
        log.info("======");
        return head;
    }

    /**
     * 构造一个指定长度的升序链表结构
     * @param range
     * @return
     */
    private Node<Integer> generateSortedIntLinkedList(int range) {
        Node<Integer> head = new Node<Integer>(0, null);
        Node<Integer> curr = head;
        Node<Integer> next;
        for (int i = 1; i < range; i++) {
            next = new Node<Integer>(i, null);
            curr.setNext(next);
            curr = next;
        }
        logLinkedList(head);
        log.info("======");
        return head;
    }

    /**
     * 遍历打印一个链表
     * @param result
     */
    private void logLinkedList(Node<Integer> result) {
        while (result!=null) {
            log.info(result.getValue().toString());
            result = result.getNext();
        }
    }

    @Test
    public void testReverseListIteratively(){
        Node<Integer> head = randomIntLinkedList(10);
        Node<Integer> result = LinkedListUtil.reverseListIteratively(head);
        logLinkedList(result);
    }

    @Test
    public void testReverseListRecursively(){
        Node<Integer> head = randomIntLinkedList(10);
        Node<Integer> result = LinkedListUtil.reverseListRecursively(head);
        logLinkedList(result);
    }

    @Test
    public void testReverseKGroup(){
        Node<Integer> head = randomIntLinkedList(21);
        Node<Integer> result = LinkedListUtil.reverseKGroup(head,6);
        logLinkedList(result);
    }

    @Test
    public void testMergeTwoLists(){
        Node<Integer> list1 = generateSortedIntLinkedList(3);
        Node<Integer> list2 = generateSortedIntLinkedList(5);

        Node<Integer> result = LinkedListUtil.mergeTwoLists(list1,list2);
        logLinkedList(result);
    }

}
