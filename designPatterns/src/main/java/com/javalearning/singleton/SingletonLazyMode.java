package com.javalearning.singleton;

/**
 * Created by renqun.yuan on 2015/10/14.
 */
public class SingletonLazyMode {
    private volatile static SingletonLazyMode instance = null;

    private SingletonLazyMode() {
    }

    // double-check
    public static SingletonLazyMode getInstance() {
        if (instance == null) {
            synchronized (SingletonLazyMode.class) {
                if (instance == null) {
                    instance = new SingletonLazyMode();
                }
            }
        }
        return instance;
    }
}
