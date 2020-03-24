package com.zaomianbao.algorithm.queue;

import com.zaomianbao.algorithm.util.CommonException;

/**
 * @Description LinkedDequeUtil
 * @Author zaomianbao
 * @Date 2020/3/24
 **/
public class LinkedDequeUtil {

    private LinkedDequeUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
     * Follow up:
     * Could you solve it in linear time?
     * Example:
     * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
     * Output: [3,3,5,5,6,7]
     * NO.239
     * @param num
     * @param size
     * @return
     */
    public static int[] maxSlidingWindow(int[] num,int size){
        //参数校验
        if(num == null || num.length < 1 || size <= 0 || size > num.length) {
            throw new CommonException(-1,"参数异常");
        }
        //初始化结果数据
        int[] result = new int[num.length-size+1];
        //结果数组下标
        int a = 0;
        //初始化即将使用到的双端队列
        Deque<Integer> deque = new LinkedDeque<Integer>();
        //遍历参数数组
        for( int i = 0 ; i < num.length ; i++ ){

            //获取队列头部的值(不弹出)
            Integer head = deque.peekFirst();

            //超出范围的移除队列头部元素
            while( deque.peekFirst() != null && deque.peekFirst() <i-size+1) {
                deque.pollFirst();
            }

            //当前循环下标对应的值大于队列尾部的值
            while( deque.peekFirst() != null && num[i] >= num[deque.peekLast()]) {
                deque.pollLast();
            }
            //将当前下标保存到队列尾部
            deque.offerLast(i);

            //此时开始是第一个滑动窗口
            if(i>=size-1){
                result[a] = num[deque.peekFirst()];
                a++;
            }
        }

        return result;
    }

}
