package com.zaomianbao.algorithm.leecode;

import lombok.extern.slf4j.Slf4j;
import java.util.HashMap;
import java.util.Map;

/**
 *
 Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 You can return the answer in any order.



 Example 1:

 Input: nums = [2,7,11,15], target = 9
 Output: [0,1]
 Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 Example 2:

 Input: nums = [3,2,4], target = 6
 Output: [1,2]
 Example 3:

 Input: nums = [3,3], target = 6
 Output: [0,1]


 Constraints:

 2 <= nums.length <= 105
 -109 <= nums[i] <= 109
 -109 <= target <= 109
 Only one valid answer exists.

 *
 * @author zaomianbao
 * @date 2020/9/4
 **/
@Slf4j
public class Question1TwoSum {

    public static void main(String[] args) {
        int[] numArray = {1,3,9,18,132,78};
        int target = 27;
        int[] result = twoSum3(numArray, target);
        log.info("结果为：{}",result);
    }

    private static int[] twoSum1(int[] numArray, int target) {
        int[] result = new int[2];
        boolean flag = false;
        for(int i = 0; i < numArray.length; i ++){
            for(int j = i + 1; j < numArray.length; j ++){
                if (numArray[i] + numArray[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        return result;
    }

    private static int[] twoSum2(int[] numArray, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(8);
        for(int i = numArray.length -1 ; i >= 0; i --){
            map.put(numArray[i],i);
        }
        for(int i = 0; i < numArray.length; i ++){
            Integer index = map.get(target - numArray[i]);
            if (index != null && index != i) {
                result[0] = i;
                result[1] = index;
                break;
            }
        }
        return result;
    }

    private static int[] twoSum3(int[] numArray, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(8);
        for(int i = 0 ; i < numArray.length; i ++){
            if (map.containsKey(target - numArray[i])) {
                result[0] = map.get(target - numArray[i]);
                result[1] = i;
                return result;
            } else {
                map.put(numArray[i],i);
            }
        }
        return result;
    }

}
