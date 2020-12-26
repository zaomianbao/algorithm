package com.zaomianbao.algorithm.leecode;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *              Note: You may assume the string contains only uppercase alphabets.
 * @author zaomianbao
 * @date 2020/3/21
 **/
@Slf4j
public class ValidAnagram242 {

    private static final Map<Character,Integer> CHAR_MAP = new HashMap<>();

    static {
        CHAR_MAP.put('A',0);CHAR_MAP.put('J',0);CHAR_MAP.put('S',0);
        CHAR_MAP.put('B',0);CHAR_MAP.put('K',0);CHAR_MAP.put('T',0);
        CHAR_MAP.put('C',0);CHAR_MAP.put('L',0);CHAR_MAP.put('U',0);
        CHAR_MAP.put('D',0);CHAR_MAP.put('M',0);CHAR_MAP.put('V',0);
        CHAR_MAP.put('E',0);CHAR_MAP.put('N',0);CHAR_MAP.put('W',0);
        CHAR_MAP.put('F',0);CHAR_MAP.put('O',0);CHAR_MAP.put('X',0);
        CHAR_MAP.put('G',0);CHAR_MAP.put('P',0);CHAR_MAP.put('Y',0);
        CHAR_MAP.put('H',0);CHAR_MAP.put('Q',0);CHAR_MAP.put('Z',0);
        CHAR_MAP.put('I',0);CHAR_MAP.put('R',0);
    }

    public static Boolean validAnagram(String origin,String other) {
        char[] originBytes = origin.toCharArray();
        char[] otherBytes = other.toCharArray();
        int[] letterArrays = new int[26];
        for (int i = 0;i<originBytes.length;i++) {
            letterArrays[CHAR_MAP.get(originBytes[i])]++;
        }
        for (int i = 0;i<otherBytes.length;i++) {
            if (letterArrays[CHAR_MAP.get(otherBytes[i])]==0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        log.info(validAnagram("ADSG","DAGSG").toString());
    }
}
