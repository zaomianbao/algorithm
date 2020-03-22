package com.zaomianbao.algorithm.linkedlist;

import com.zaomianbao.algorithm.util.CommonException;

/**
 * @Description LinkedListUtil
 * @Author zaomianbao
 * @Date 2020/3/21
 **/
public class LinkedListUtil {

    private LinkedListUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 迭代的方式实现链表倒转
     * @param head
     * @param <T>
     * @return
     */
    public static<T> Node<T> reverseListIteratively(Node<T> head) {
        //当为null和一个节点时直接返回
        if (head == null || head.getNext() == null) {
            return head;
        }
        //定义两个指针，一个prev用于记录一次操作中的head节点，一个next用于记录一次操作中的last节点
        Node<T> curr = head;
        Node<T> pre = null;
        //收敛条件，一直迭代到链尾
        while (curr != null) {
            //暂存一下当前节点在没倒转前的下一个节点，防止变化指针指向后找不到后续的节点
            Node<T> tmp = curr.getNext();
            //这一步是真正的倒转的操作
            curr.setNext(pre);
            //pre指针后移一位，将当前操作的节点作为下一个循环操作节点的下一个节点
            pre = curr;
            //curr节点后移一位，将之前暂存的节点（原链表的下一节点）作为下一次需要操作的节点
            curr = tmp;
        }
        //到这里代表链表已经迭代结束，这个pre节点最终也变成了链表倒转后的头结点
        return pre;
    }

    /**
     * 递归的方式实现链表倒转
     * @param node
     * @param <T>
     * @return
     */
    public static<T> Node<T> reverseListRecursively(Node<T> node) {
        //判断空值
        if (node == null) {
            throw new CommonException(-1,"NullPointException");
        }
        //递归收敛条件
        if (node.getNext() == null) {
            //到末节点时即返回，同时这个末节点最终会递归返回至最外层，作为链表倒转后的新头部节点
            return node;
        }

        Node<T> next = node.getNext();

        //这个方法会一直追溯到末节点
        Node<T> newHead = reverseListRecursively(next);
        //末节点返回回来后在依次执行以下两行代码
        //翻转链表的指向
        next.setNext(node);
        //这一步最主要的作用是将原头部节点的next置为null，避免形成环
        node.setNext(null);
        return newHead;
    }

    /**
     *   Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
     *   k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
     *   Example:
     *   Given this linked list: 1->2->3->4->5
     *   For k = 2, you should return: 2->1->4->3->5
     *   For k = 3, you should return: 3->2->1->4->5
     *   Note:
     *   Only constant extra memory is allowed.
     *   You may not alter the values in the list's nodes, only nodes itself may be changed.
     * @param node
     * @param <T>
     * @return
     */
    public static<T> Node<T> reverseKGroup(Node<T> node,int k){

        //空值判定
        if ( node == null ) {
            return null;
        }

        //定义三个指正，当前节点指针、当前节点翻转前的上一节点指针、当前节点翻转前的下一节点指针
        Node<T> curr = node;
        Node<T> pre = null;
        Node<T> next;
        //存储组大小的副本
        int j = k;
        while ( j-- > 0) {
            //next指针赋值
            next = curr.getNext();
            //当前指针所指节点进行翻转，指向前一节点，第一次时指向的是null
            curr.setNext(pre);
            //当处理到最后一组，但最后一组长度不足时的处理逻辑，即将已经翻转过来的最后一组子链表恢复原样，也即再翻转回来，这一步一定要在curr.setNext(pre)之后，否则会节点丢失
            if (next == null) {
                //调用我之前写好的一个递归方式进行全链表翻转的静态方法实现链表复原
                return reverseListRecursively(curr);
            }
            //pre指针沿着链表向下移动一节
            pre = curr;
            //curr指针沿着链表向下移动一节
            curr = next;
        }
        //一组循环结束后进行剩余子链表的翻转
        Node<T> subHead = reverseKGroup(curr, k);
        //递归回来，从后往前拼接已经翻转后的字串
        node.setNext(subHead);
        //递归调用中返回翻转并拼接后的子链表的头节点，最外层则的是返回整个按k组翻转后的链表头
        return pre;
    }

    /**
     *   Merge two sorted linked lists and return it as a new list.
     *   The new list should be made by splicing together the nodes of the first two lists.
     *   Example:
     *   Input: 1->2->4, 1->3->4
     *   Output: 1->1->2->3->4->4
     * @param l1
     * @param l2
     * @return
     */
    public static Node<Integer> mergeTwoLists(Node<Integer> l1,Node<Integer> l2){

        //空值判定
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        //创建一个空的链表头
        Node<Integer> newHead;
        if (l1.getValue() <= l2.getValue()) {
            newHead = l1;
            //递归调用，直至链尾回归拼接到next
            newHead.setNext(mergeTwoLists(l1.getNext(), l2));
        }else {
            newHead = l2;
            newHead.setNext(mergeTwoLists(l1,l2.getNext()));
        }
        return newHead;
    }

}
