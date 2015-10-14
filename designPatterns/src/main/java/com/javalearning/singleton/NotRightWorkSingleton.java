package com.javalearning.singleton;

/**
 * Created by renqun.yuan on 2015/10/14.
 */
public class NotRightWorkSingleton {
    private static NotRightWorkSingleton instance = null;

    private NotRightWorkSingleton() {
    }

    /**
     * In multiThread, it can't work
     *
     * @return
     */
    public static NotRightWorkSingleton getInstance() {
        if (instance == null) {
            instance = new NotRightWorkSingleton();
        }
        return instance;
    }

    /**
     * 'new' may not a atomic operation,
     * instruct can be reorder
     * volatile used can be will work, see: SingletonLazyMode.java
     *
     * @return
     */
    public static NotRightWorkSingleton getInstance1() {
        if (instance == null) {
            synchronized (SingletonLazyMode.class) {
                if (instance == null) {
                    instance = new NotRightWorkSingleton();
                }
            }
        }
        return instance;
    }
}
