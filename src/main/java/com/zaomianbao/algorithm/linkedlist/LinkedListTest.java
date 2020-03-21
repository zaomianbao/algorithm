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

    @Test
    public void testReverseListIteratively(){
        ListNode<Integer> head = new ListNode<Integer>(0,null);
        ListNode<Integer> pre = head;
        ListNode<Integer> next;
        Random random = RandomFactory.RANDOM.getRandom();
        for (int i = 1 ; i < 10 ; i ++ ) {
            next = new ListNode<Integer>(random.nextInt(20),null);
            pre.setNext(next);
            pre = next;
        }
        ListNode<Integer> tmp = head;
        while (tmp!=null) {
            log.info(tmp.getValue().toString());
            tmp = tmp.getNext();
        }
        log.info("======");
        ListNode<Integer> result = ReverseLinkedList.reverseListIteratively(head);
        while (result!=null) {
            log.info(result.getValue().toString());
            result = result.getNext();
        }
    }

}
