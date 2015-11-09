package com.javalearning.guavaexample.base;

import com.google.common.base.CaseFormat;

/**
 * Created by renqun.yuan on 2015/11/9.
 */
public class CaseFormatExample {
    public static void main(String[] args) {
        System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, "helloTest"));
    }
}
