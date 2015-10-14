package com.javalearning.strategy;

/**
 * Created by renqun.yuan on 2015/10/14.
 */
public class StrategyTest {
    public static void main(String[] args) {
        Strategy lowerStrategy = new WordLowerStrategy();
        Situation lowerSituation = new Situation(lowerStrategy);
        System.out.println(lowerSituation.transformWord("Test"));

        String transformWord = StringTransform.transform("hello", new Strategy() {
            @Override
            public String apply(String word) {
                if (word == null) {
                    return "";
                }
                return word.toUpperCase();
            }
        });

        System.out.println(transformWord);
    }
}
