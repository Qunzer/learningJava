package com.javalearning.guavaexample.collection;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;

/**
 * Created by renqun.yuan on 2015/10/16.
 */
public class BiMapExample {
    public static void hashBiMapExample() {
        HashBiMap<String, String> biMap = HashBiMap.create();
        biMap.put("foo", "boy");
//        biMap.put("boy", "boy"); //IllegalArgumentException: value already present: boy
//        biMap.forcePut("boy", "boy");// ok, foo=boy is removed
        System.out.println(biMap);

        BiMap<String, String> inverse = biMap.inverse();

        System.out.println(inverse);

    }

    public static void immutableBiMap() {
        ImmutableBiMap<Object, Object> immutableBiMap = ImmutableBiMap.builder().put("foo", "bar").build();

        System.out.println(immutableBiMap);

        System.out.println(immutableBiMap.inverse());
    }

    public static void main(String[] args) {
        hashBiMapExample();
        immutableBiMap();
    }
}
