package com.javalearning.strategy;

/**
 * Created by renqun.yuan on 2015/10/14.
 */
public class StringTransform {
    public static String transform(String word, Strategy strategy) {
        return strategy.apply(word);
    }
}
