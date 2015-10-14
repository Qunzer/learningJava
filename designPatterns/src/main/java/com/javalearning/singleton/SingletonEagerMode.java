package com.javalearning.singleton;

/**
 * Created by renqun.yuan on 2015/10/14.
 */
public class SingletonEagerMode {
    // when the class is loaded, the instance is initialized
    private static final SingletonEagerMode instance = new SingletonEagerMode();

    private SingletonEagerMode() {
    }

    public static SingletonEagerMode getInstance() {
        return instance;
    }
}
