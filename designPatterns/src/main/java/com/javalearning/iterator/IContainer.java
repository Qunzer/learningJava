package com.javalearning.iterator;

import java.util.Iterator;

/**
 * Created by renqun.yuan on 2015/11/5.
 */
public interface IContainer<T> {
    Iterator<T> create();
}
