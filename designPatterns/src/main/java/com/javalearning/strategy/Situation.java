package com.javalearning.strategy;

/**
 * Created by renqun.yuan on 2015/10/14.
 */
public class Situation {
    private Strategy strategy;

    Situation(Strategy strategy) {
        this.strategy = strategy;
    }

    public String transformWord(String word) {
        return strategy.apply(word);
    }
}
