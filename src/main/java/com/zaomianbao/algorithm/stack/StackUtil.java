package com.zaomianbao.algorithm.stack;

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
        //首先创建一个空栈
        Stack<Character> stack = new LinkedListStack<Character>();
        for (int i = 0; i < chars.length; i++) {
            //当栈中没有元素同时循环没结束时直接压入栈中
            if (stack.peek() == null) {
                stack.push(chars[i]);
                continue;
            }
            if (compareParentheses(stack.peek(),chars[i])) {
                //匹配则将栈顶弹出
                stack.pop();
            }else {
                //不匹配则压入栈中
                stack.push(chars[i]);
            }
        }
        //最终循环结束，如果栈中没有元素了，即代表所有元素完全匹配
        return stack.peek() == null;

    }

    /**
     * 符号匹配判定
     * @param a
     * @param b
     * @return
     */
    private static boolean compareParentheses(Character a,Character b){
        return (a.equals('[') && b.equals(']')) || (a.equals('{') && b.equals('}')) || (a.equals('(') && b.equals(')'));
    }

    /**
     * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
     * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
     * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {

        //首先创建一个空栈
        Stack<Integer> stack = new LinkedListStack<Integer>();
        //再创建一个存放结果的数组
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            //查看栈顶元素
            Integer peek = stack.peek();
            //当栈顶元素不为空(栈内有元素)同时栈顶元素存放的下标对应的温度值小于当前循环下标的温度值时进入循环操作
            while (peek != null && temperatures[peek] < temperature) {
                //算出当前下标和栈顶元素对应下标相隔几天(几个下标)，并将该值存入到结果数组中对应栈顶元素的值对应下标的位置
                result[peek] = i - peek;
                //将计算过下标的这个栈顶元素弹出
                stack.pop();
                //重新获取最新栈顶元素
                peek = stack.peek();
            }
            //走到这时说明栈里没元素了或者当前下标对应的温度没有栈顶元素的值所对应的下标下的温度高
            stack.push(i);
        }
        return result;

    }
}
