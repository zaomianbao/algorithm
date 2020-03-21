package com.zaomianbao.algorithm.leecode;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description Given two strings s and t , write a function to determine if t is an anagram of s.
 *              Note: You may assume the string contains only uppercase alphabets.
 * @Author zaomianbao
 * @Date 2020/3/21
 **/
@Slf4j
public class ValidAnagram242 {

    private static final Map<Character,Integer> map = new HashMap<Character,Integer>();

    static {
        map.put('A',0);map.put('J',0);map.put('S',0);
        map.put('B',0);map.put('K',0);map.put('T',0);
        map.put('C',0);map.put('L',0);map.put('U',0);
        map.put('D',0);map.put('M',0);map.put('V',0);
        map.put('E',0);map.put('N',0);map.put('W',0);
        map.put('F',0);map.put('O',0);map.put('X',0);
        map.put('G',0);map.put('P',0);map.put('Y',0);
        map.put('H',0);map.put('Q',0);map.put('Z',0);
        map.put('I',0);map.put('R',0);
    }

    public static Boolean validAnagram(String origin,String other) {
        char[] originBytes = origin.toCharArray();
        char[] otherBytes = other.toCharArray();
        int[] letterArrays = new int[26];
        for (int i = 0;i<originBytes.length;i++) {
            letterArrays[map.get(originBytes[i])]++;
        }
        for (int i = 0;i<otherBytes.length;i++) {
            if (letterArrays[map.get(otherBytes[i])]==0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        log.info(validAnagram("ADSG","DAGSG").toString());
    }
}
