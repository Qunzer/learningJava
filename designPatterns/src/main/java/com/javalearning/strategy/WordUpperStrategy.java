package com.javalearning.strategy;

/**
 * Created by renqun.yuan on 2015/10/14.
 */
public class WordUpperStrategy implements Strategy {
    @Override
    public String apply(String word) {
        if (word == null) {
            return "";
        }
        return word.toUpperCase();
    }
}
