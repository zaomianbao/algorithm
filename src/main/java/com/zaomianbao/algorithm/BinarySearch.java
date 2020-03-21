package com.zaomianbao.algorithm;

/**
 * 二叉查找
 */
public class BinarySearch {
    public static int rank(int key,int[] a){
        int begin = 0;
        int end = a.length - 1;
        while (begin <= end){
            int mid = begin + (end - begin)/2;
            if(key < a[mid]) end = mid - 1;
            else if (key > a[mid]) begin = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,10};
        int result = rank(10, a);
        System.out.println(result + " " + a[result]);
    }
}
