package com.javalearning;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by renqun.yuan on 2015/12/7.
 */
public class MergeMaxNum {

    /**
     * Write a function that given a list of non negative integers,
     * arranges them such that they form the largest possible number.
     * For example, given [50, 2, 1, 9], the largest formed number is 95021.
     */
    public static void main(String[] args) {
        Integer[] integers = {3, 2, 5};
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString();
                String s2 = o2.toString();
                return (s1 + s2).compareTo(s2 + s1) * -1;
            }
        });
        String result = "";
        for (Integer integer : integers) {
            result += integer;
        }
        System.out.println(result);
    }
}
