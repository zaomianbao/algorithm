package com.zaomianbao.algorithm.stack;

import com.zaomianbao.algorithm.util.CommonException;

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

    /**
     * 使用栈实现一个基础计算机
     * 可以解决LeetCode 224、227题
     * @param expression
     * @return
     */
    public static int calculateExpression(String expression) {
        return calRpn(convertToRpn(expression));
    }

    /**
     * 中缀表达式转逆波兰表达式(后缀表达式)
     * @param expression
     * @return
     */
    private static String convertToRpn(String expression) {
        char[] arr = expression.toCharArray();
        LinkedListStack<Character> stack = new LinkedListStack<Character>();
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            char ch = arr[i];
            if(ch == ' ') continue;
            // if is operand, add to the output stream directly
            if(ch >= '0' && ch <= '9') {
                out.append(ch);
                continue;
            }
            //if is '(', push to the stack directly
            if(ch == '(') stack.push(ch);
            //if is '+' or '-', pop the operator from the stack until '(' and add to the output stream
            //push the operator to the stack
            if(ch == '+' || ch == '-'){
                while(stack.peek()!=null && (stack.peek() != '(')){
                    out.append(stack.pop());
                }
                stack.push(ch);
                continue;
            }

            //if is '*' or '/', pop the operator stack and add to the output stream until lower priority or '('
            //push the operator to the stack
            if(ch == '*' || ch == '/'){
                while(stack.peek()!=null && (stack.peek() == '*' || stack.peek() == '/')) {
                    out.append(stack.pop());
                }
                stack.push(ch);
                continue;
            }

            //if is ')' pop the operator stack and add to the output stream until '(',
            //pop '('
            if(ch == ')'){
                while(stack.peek()!=null && stack.peek() != '(') {
                    out.append(stack.pop());
                }
                stack.pop();
            }
        }
        //pop rest of the operator in stack
        while(stack.peek()!=null) {
            out.append(stack.pop());
        }
        return out.toString();
    }

    /**
     * calculate the value of the RPE(Reverse Polish Expression)
     * @param rpe - Reverse Polish expression
     * @return - result of the expression
     */
    private static int calRpn(String rpe){
        Stack<Integer> v = new LinkedListStack<Integer>();
        char[] arr = rpe.toCharArray();
        for(int i = 0; i < arr.length; i++){
            Character ch = arr[i];
            // if is operand, push to the stack
            if(ch >= '0' && ch <= '9') {
                v.push(ch - '0');
            }else {
                // if is operator, calculate the result
                // with top 2 operands in the stack,
                // push the result into the stack
                v.push(calculateTwoValue(ch, v.pop(), v.pop()));
            }
        }
        return v.pop();
    }

    private static int calculateTwoValue(char op, int f1, int f2){
        if(op == '+') return f2 + f1;
        else if(op == '-') return f2 - f1;
        else if(op  == '*') return f2 * f1;
        else if(op == '/') return f2 / f1;
        else throw new CommonException(-1,"非法操作符");
    }

}
