package com.javalearning.collection;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by renqun.yuan on 2015/8/12.
 */
public class FluentIterableExample {

    private static void copyInto() {
        List<String> dest = Lists.newArrayList("1", "2");
        List<String> src = Lists.newArrayList("3");
        FluentIterable.from(src).copyInto(dest); // desc改变
        System.out.println(dest);
    }

    private static void join() {
        List<String> dest = Lists.newArrayList("1", "2");
        String join = FluentIterable.from(dest).join(Joiner.on("-").skipNulls());
        System.out.println(join);
    }

    private static void toMap() {
        List<Kv> kvs = Lists.newArrayList(new Kv("hello", "world"), new Kv("1", "CNY"));
        ImmutableMap<Kv, Object> kvObjectImmutableMap = FluentIterable.from(kvs).toMap(new Function<Kv, Object>() {
            @Override
            public Object apply(Kv input) {
                return input.getKey();
            }
        });

        System.out.println(kvObjectImmutableMap);
    }

    private static void append() {
        List<Kv> kvs = Lists.newArrayList(new Kv("hello", "world"), new Kv("1", "CNY"));
        ImmutableList<Kv> usd = FluentIterable.from(kvs).append(new Kv("2", "USD")).toList();// 不会修改原来
        System.out.println(usd);
        System.out.println(kvs);
    }

    private static void index() {
        List<Kv> kvs = Lists.newArrayList(new Kv("hello", "world"), new Kv("1", "CNY"));

        ImmutableListMultimap<Object, Kv> index = FluentIterable.from(kvs).index(new Function<Kv, Object>() {
            @Override
            public Object apply(Kv input) {
                return input.getKey();
            }
        });

        ImmutableMap<Object, Kv> objectKvImmutableMap = FluentIterable.from(kvs).uniqueIndex(new Function<Kv, Object>() {
            @Override
            public Object apply(Kv input) {
                return input.getKey();
            }
        });
    }

    private static void skip() {
        List<Kv> kvs = Lists.newArrayList(new Kv("hello", "world"), new Kv("1", "CNY"));
        ImmutableList<Kv> kvs1 = FluentIterable.from(kvs).skip(1).toList();
        System.out.println(kvs);
        System.out.println(kvs1);
    }

    private static void cycle() {
        List<String> kvs = Lists.newArrayList("hello", "test", "hello");
        FluentIterable.from(kvs).cycle().iterator();
    }

    private static void match() {
        List<Kv> kvs = Lists.newArrayList(new Kv("hello", "world"), new Kv("1", "CNY"));
        boolean b = FluentIterable.from(kvs).allMatch(new Predicate<Kv>() {
            @Override
            public boolean apply(Kv input) {
                return input.getKey().equals("1");
            }
        });

        System.out.println("allMatch:" + b);

        boolean b1 = FluentIterable.from(kvs).anyMatch(new Predicate<Kv>() {
            @Override
            public boolean apply(Kv input) {
                return input.getKey().length() > 1;
            }
        });

        System.out.println("anyMatch:" + b1);
    }

    private static void compact() {
        List<Kv> kvs = Lists.newArrayList(new Kv("hello", "world"), new Kv("1", "CNY"));
        ArrayList<Kv> hsc = FluentIterable.from(kvs).filter(new Predicate<Kv>() {
            @Override
            public boolean apply(Kv input) {
                return input.getKey().length() > 1;
            }
        }).copyInto(Lists.newArrayList(new Kv("5", "HSC")));
        System.out.println(hsc);
    }

    private static void toSet() {
        List<String> kvs = Lists.newArrayList("hello", "test", "hello");

        ImmutableSet<Object> objects = FluentIterable.from(kvs).transform(new Function<String, Object>() {
            @Override
            public Object apply(String input) {
                return input.length();
            }
        }).toSet();
        System.out.println(objects);

        ImmutableList<String> strings = FluentIterable.from(kvs).toSortedList(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("sortedList: " + strings);
    }

    public static void main(String[] args) {
//        copyInto();
//        join();
//        toMap();
        append();
//        index();
//        compact();
//        toSet();
//        skip();
        transFromAndConcat();
    }

    private static void transFromAndConcat() {
        Inner a = new Inner("a");
        Inner b = new Inner("b");
        List<Inner> inners = Lists.newArrayList(a, b);
        Outer outC = new Outer("c", inners);
        Outer outD = new Outer("d", inners);
        List<Outer> outers= Lists.newArrayList(outC, outD);
        FluentIterable<Merged> mergeds = FluentIterable.from(outers).transformAndConcat(new Function<Outer, Iterable<Merged>>() {
            @Override
            public Iterable<Merged> apply(Outer input) {
                List<Merged> mergeds = Lists.newArrayList();
                for (Inner inner : input.getFrieds()) {
                    Merged merged = new Merged();
                    merged.setUserName(input.getUserName());
                    merged.setFriendName(inner.getName());
                    mergeds.add(merged);
                }
                return mergeds;
            }
        });
        for (Merged merged : mergeds.toList()) {
            System.out.println(merged);
        }
    }
}
