package com.zaomianbao.algorithm.stack;

import com.zaomianbao.algorithm.linkedlist.ListNode;

/**
 * @Description StackUtil
 * @Author zaomianbao
 * @Date 2020/3/22
 **/
public class StackUtil {

    private StackUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * An input string is valid if:
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     * Example 1:
     * Input: "()"
     * Output: true
     * Example 2:
     * Input: "()[]{}"
     * Output: true
     * Example 3:
     * Input: "(]"
     * Output: false
     * Example 4:
     * Input: "([)]"
     * Output: false
     * Example 5:
     * Input: "{[]}"
     * Output: true
     * @param s
     * @return
     */
    public static Boolean isValidParentheses(String s){
        //默认空的情况下返回false
        if (null == s) {
            return false;
        }
        char[] chars = s.toCharArray();
        ListNode<Character> head = new ListNode<Character>();
        head.setValue(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (head == null) {
                head = new ListNode<Character>();
                head.setValue(chars[i]);
                continue;
            }
            if (compareParentheses(head.getValue(),chars[i])) {
                head = head.getNext();
            }else {
                ListNode<Character> newHead = new ListNode<Character>();
                newHead.setValue(chars[i]);
                newHead.setNext(head);
                head = newHead;
            }
        }
        if (head != null) {
            return false;
        }
        return true;
    }

    /**
     * 符号匹配判定
     * @param a
     * @param b
     * @return
     */
    private static boolean compareParentheses(Character a,Character b){
        if (a.equals('[') && b.equals(']')) {
            return true;
        }
        if (a.equals('{') && b.equals('}')) {
            return true;
        }
        if (a.equals('(') && b.equals(')')) {
            return true;
        }
        return false;
    }

}
