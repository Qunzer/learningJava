package com.javalearning.collection;

import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.LazyMap;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by renqun.yuan on 2015/11/4.
 */
public class LazyMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        LazyMap<String, Integer> lazyMap = LazyMap.lazyMap(map, new Transformer<String, Integer>() {
            @Override
            public Integer transform(String input) {
                if (StringUtils.isNotBlank(input)) {
                    return Integer.parseInt(input);
                }
                return null;
            }
        });

        lazyMap.get("123");

        lazyMap.get("123");
        System.out.println(lazyMap.size());
        lazyMap.get("12");

        System.out.println(lazyMap.size());
    }
}
