package com.javalearning.iterator;

import java.util.Iterator;

/**
 * Created by renqun.yuan on 2015/11/5.
 */
public class ListIterator<T> implements IContainer<T> {
    @Override
    public Iterator<T> create() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }

            @Override
            public void remove() {

            }
        };
    }
}
