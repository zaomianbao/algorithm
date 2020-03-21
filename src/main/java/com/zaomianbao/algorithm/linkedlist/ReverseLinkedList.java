package com.zaomianbao.algorithm.linkedlist;

import com.zaomianbao.algorithm.util.CommonException;

/**
 * @Description ReverseLinkedList
 * @Author zaomianbao
 * @Date 2020/3/21
 **/
public class ReverseLinkedList {

    private ReverseLinkedList() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 迭代的方式实现链表倒转
     * @param head
     * @param <T>
     * @return
     */
    public static<T> ListNode<T> reverseListIteratively(ListNode<T> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        //定义两个指针，一个prev用于记录一次操作中的head节点，一个next用于记录一次操作中的last节点
        ListNode<T> prev = head;
        ListNode<T> next = null;
        //收敛条件，一直迭代到链尾
        while (prev != null) {
            //暂存一下当前节点在没倒转前的下一个节点，防止变化指针指向后找不到后续的节点
            ListNode<T> tmp = prev.getNext();
            //这一步是真正的倒转的操作
            prev.setNext(next);
            //将当前循环操作的节点作为下一次循环的next节点
            next = prev;
            //将之前暂存的节点（原链表的下一节点）作为下一次需要操作的节点
            prev = tmp;
        }
        //到这里代表链表已经迭代结束，这个next节点最终也变成了链表倒转后的头结点
        return next;
    }

    /**
     * 递归的方式实现链表倒转
     * @param node
     * @param <T>
     * @return
     */
    public static<T> ListNode<T> reverseListRecursively(ListNode<T> node) {
        //判断空值
        if (node == null) {
            throw new CommonException(-1,"NullPointException");
        }
        //递归收敛条件
        if (node.getNext() == null) {
            //到末节点时即返回，同时这个末节点最终会递归返回至最外层，作为链表倒转后的新头部节点
            return node;
        }

        ListNode<T> next = node.getNext();

        //这个方法会一直追溯到末节点
        ListNode<T> newHead = reverseListRecursively(next);
        //末节点返回回来后在依次执行以下两行代码
        //翻转链表的指向
        next.setNext(node);
        //这一步最主要的作用是将原头部节点的next置为null，避免形成环
        node.setNext(null);
        return newHead;
    }


}
