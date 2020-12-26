package com.zaomianbao.algorithm.leecode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 Given a string s, find the length of the longest substring without repeating characters.

 Example 1:

 Input: s = "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.
 Example 2:

 Input: s = "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.
 Example 3:

 Input: s = "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 Example 4:

 Input: s = ""
 Output: 0

 Constraints:

 0 <= s.length <= 5 * 104
 s consists of English letters, digits, symbols and spaces.
 *
 * @author zaomianbao
 * @date 2020/9/8
 **/
@Slf4j
public class Question3LengthOfLongestSubstring {

    public static void main(String[] args) {
        int result = lengthOfLongestSubstring("affeweras");
        log.info("结果为：{}",result);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> charMap = new HashMap<>(16);
        int result = 1;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer tmp = charMap.get(s.charAt(i));
            if (tmp != null) {
                if (i - tmp > result) {
                    result = i - tmp;
                }
                index = 1;
            } else {

            }
            charMap.put(s.charAt(i),i);
        }
        return result;
    }

}
