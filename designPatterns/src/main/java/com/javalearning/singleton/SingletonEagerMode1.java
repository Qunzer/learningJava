package com.javalearning.singleton;

/**
 * Created by renqun.yuan on 2015/10/14.
 */
public class SingletonEagerMode1 {
    // when the getInstance method is invoked, the instance is  initialized
    private static class SingletonInstanceHolder {
        private static final SingletonEagerMode1 INSTANCE = new SingletonEagerMode1();
    }

    private SingletonEagerMode1() {
    }

    public static SingletonEagerMode1 getInstance() {
        return SingletonInstanceHolder.INSTANCE;
    }
}
