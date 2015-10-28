package com.javalearning.guavaexample.collection;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Lists;

/**
 * Created by renqun.yuan on 2015/10/19.
 */
public class TableExample {
    public static void arrayTable() {
        ArrayTable<String, String, Integer> arrayTable = ArrayTable.<String, String, Integer>create(Lists.newArrayList("hello"), Lists.newArrayList("test"));
        Integer value = arrayTable.get("hello", "test");
        System.out.println(value);

//      arrayTable.put("hello", "world", 2); // IllegalArgumentException: Column must in the column list

        arrayTable.put("hello", "test", 2); // ok
        System.out.println(arrayTable.get("hello", "test"));

    }

    public static void hashBasedTable() {
        HashBasedTable<String, String, String> hashBasedTable = HashBasedTable.create();
        hashBasedTable.put("hello", "world", "java");
        System.out.println(hashBasedTable.get("hello", "world"));

        hashBasedTable.put("hello", "world", "python");
        System.out.println(hashBasedTable.get("hello", "world"));
    }

    private static void immutableTable() {
        ImmutableTable.Builder<String, String, String> builder = ImmutableTable.builder();
        builder.put("hello", "world", "java");
        builder.put("hello", "xxxx", "python");
        ImmutableTable<String, String, String> immutableTable = builder.build();
        System.out.println(immutableTable.size());
        System.out.println(immutableTable.get("hello", "world"));
    }

    public static void main(String[] args) {
        arrayTable();
        hashBasedTable();
        immutableTable();
    }
}
