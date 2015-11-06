package com.javalearning.concurrent;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.LazyInitializer;

/**
 * Created by renqun.yuan on 2015/11/6.
 */
public class LazyInitializerExample {
    public static void main(String[] args) throws ConcurrentException {
        LazyInitializerTest lazyInitializerTest = new LazyInitializerTest();

        System.out.println(lazyInitializerTest.get());
        System.out.println(lazyInitializerTest.get());

    }

   static class LazyInitializerTest extends LazyInitializer<String>{

        /**
         * Creates and initializes the object managed by this {@code
         * LazyInitializer}. This method is called by {@link #get()} when the object
         * is accessed for the first time. An implementation can focus on the
         * creation of the object. No synchronization is needed, as this is already
         * handled by {@code get()}.
         *
         * @return the managed data object
         * @throws ConcurrentException if an error occurs during object creation
         */
        @Override
        protected String initialize() throws ConcurrentException {
            System.out.println("from the initialize method");
            return "hello";
        }
    }
}


