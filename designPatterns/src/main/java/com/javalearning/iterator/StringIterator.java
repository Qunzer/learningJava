package com.javalearning.iterator;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.IteratorUtils;

import java.util.Iterator;
import java.util.List;

/**
 * Created by renqun.yuan on 2015/11/5.
 */
public class StringIterator {
    public static Iterator<String> skipNullAndBlank(final Iterator<String> iterator) {
        return new AbstractIterator<String>() {
            @Override
            protected String computeNext() {
                while (iterator.hasNext()) {
                    String next = iterator.next();
                    if (next != null && next.trim().length() != 0) {
                        return next;
                    }
                }
                return endOfData();
            }
        };
    }

    public static Iterator<String> skipByLength(final Iterator<String> iterable) {
        return new AbstractIterator<String>() {
            @Override
            protected String computeNext() {
                while (iterable.hasNext()) {
                    String next = iterable.next();
                    if (next != null && next.length() < 6) {
                        return next;
                    }
                }
                return endOfData();
            }
        };
    }

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("hello", null, "test", "444444444");
        Iterator<String> stringIterator = skipNullAndBlank(list.iterator());
        System.out.println(IteratorUtils.toList(stringIterator));

        /*=================================*/
        Iterator<String> stringIterator1 = skipByLength(list.iterator());
        System.out.println(IteratorUtils.toList(stringIterator1));
    }
}
