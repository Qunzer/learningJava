package com.javalearning.strategy;

/**
 * Created by renqun.yuan on 2015/10/14.
 */
public class WordLowerStrategy implements Strategy {
    @Override
    public String apply(String str) {
        if (str == null) {
            return "";
        }
        return str.toLowerCase();
    }
}
