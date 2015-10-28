package com.javalearning.guavaexample.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * Created by renqun.yuan on 2015/10/28.
 */
public class CacheExample {
    private static LoadingCache<String, String> cache = CacheBuilder.newBuilder().maximumSize(10).expireAfterAccess(10, TimeUnit.HOURS).recordStats().build(new CacheLoader<String, String>() {
        @Override
        public String load(String key) throws Exception {
            return getValue(key);
        }
    });

    public static void main(String[] args) {
        System.out.println(cache.getUnchecked("hello"));
        System.out.println(cache.getUnchecked("hello"));
        System.out.println(cache.stats().hitRate());

        System.out.println(cache.getUnchecked("guava"));

        System.out.println(cache.stats().hitRate());
    }

    private static String getValue(String key) {
        System.out.println("from the method");
        return key;
    }
}
