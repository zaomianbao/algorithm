package com.zaomianbao.algorithm.linkedlist;

import com.zaomianbao.algorithm.util.RandomFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import java.util.Random;

/**
 * @Description 链表结构JUNIT测试类
 * @Author zaomianbao
 * @Date 2020/3/21
 **/
@Slf4j
public class LinkedListTest {

    /**
     * 随机构造一个指定长度的链表结构
     * @param range
     * @return
     */
    private ListNode<Integer> randomIntLinkedList(int range) {
        Random random = RandomFactory.RANDOM.getRandom();
        ListNode<Integer> head = new ListNode<Integer>(random.nextInt(20), null);
        ListNode<Integer> curr = head;
        ListNode<Integer> next;
        for (int i = 1; i < range; i++) {
            next = new ListNode<Integer>(random.nextInt(20), null);
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
    private ListNode<Integer> generateSortedIntLinkedList(int range) {
        ListNode<Integer> head = new ListNode<Integer>(0, null);
        ListNode<Integer> curr = head;
        ListNode<Integer> next;
        for (int i = 1; i < range; i++) {
            next = new ListNode<Integer>(i, null);
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
    private void logLinkedList(ListNode<Integer> result) {
        while (result!=null) {
            log.info(result.getValue().toString());
            result = result.getNext();
        }
    }

    @Test
    public void testReverseListIteratively(){
        ListNode<Integer> head = randomIntLinkedList(10);
        ListNode<Integer> result = LinkedListUtil.reverseListIteratively(head);
        logLinkedList(result);
    }

    @Test
    public void testReverseListRecursively(){
        ListNode<Integer> head = randomIntLinkedList(10);
        ListNode<Integer> result = LinkedListUtil.reverseListRecursively(head);
        logLinkedList(result);
    }

    @Test
    public void testReverseKGroup(){
        ListNode<Integer> head = randomIntLinkedList(21);
        ListNode<Integer> result = LinkedListUtil.reverseKGroup(head,6);
        logLinkedList(result);
    }

    @Test
    public void testMergeTwoLists(){
        ListNode<Integer> list1 = generateSortedIntLinkedList(3);
        ListNode<Integer> list2 = generateSortedIntLinkedList(5);

        ListNode<Integer> result = LinkedListUtil.mergeTwoLists(list1,list2);
        logLinkedList(result);
    }

}
