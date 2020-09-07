package com.zaomianbao.algorithm.leecode;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 *
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.
 *
@author zaomianbao
@date 2020/9/7
 **/
@Slf4j
public class Question2AddTwoNumbers {

    public static void main(String[] args) {
        ListNode node2 = ListNode.builder().val(1).next(null).build();
        ListNode node1 = ListNode.builder().val(9).next(ListNode.builder().val(9).next(null).build()).build();
        ListNode node = addTwoNumbers1(node1, node2);

        log.info("结果为：{}",node);

    }

    private static ListNode addTwoNumbers1(ListNode node1, ListNode node2) {
        int sum = node1.val + node2.val;
        ListNode head = new ListNode(sum % 10,null);
        ListNode curr = head;
        Integer up = 0;
        if (sum / 10 == 1) {
            up = 1;
        }
        ListNode next1 = node1.next;
        ListNode next2 = node2.next;
        while (next1 != null || next2 != null) {
            if (next1 != null && next2 != null) {
                sum = next1.val + next2.val;
                if (up == 1) {
                    sum ++;
                    up = 0;
                }
                curr.next = new ListNode(sum % 10,null);
                curr = curr.next;
                if (sum / 10 == 1) {
                    up = 1;
                }
                next1 = next1.next;
                next2 = next2.next;
            } else if (next1 == null){
                curr.next = next2;
                curr = curr.next;
                up = processOneNode(curr,up);
                next2 = next2.next;
            } else {
                curr.next = next1;
                curr = curr.next;
                up = processOneNode(curr,up);
                next1 = next1.next;
            }
        }
        if (up == 1) {
            curr.next = new ListNode(1,null);
        }
        return head;
    }

    private static Integer processOneNode(ListNode curr,Integer up){
        if (up == 1) {
            curr.val = curr.val + 1;
            up = 0;
        }
        if (curr.val / 10 == 1) {
            curr.val = curr.val % 10;
            up = 1;
        }
        return up;
    }

    @Data
    @Builder
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }

}
