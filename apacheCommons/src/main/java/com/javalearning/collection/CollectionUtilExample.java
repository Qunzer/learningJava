package com.javalearning.collection;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renqun.yuan on 2015/11/4.
 */
public class CollectionUtilExample {
    public static void main(String[] args) {
        new CollectionUtilExample().test();
    }

    public void test() {
        List<A> aList = new ArrayList<A>();
        A a = new A(1);
        aList.add(a);
        aList.add(new A(2));
        CollectionUtils.forAllDo(aList, new Closure<A>() {
            @Override
            public void execute(A input) {
                input.setId(5);
            }
        });

        System.out.println(aList);
    }

    class A {
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public A(Integer id) {

            this.id = id;
        }

        @Override
        public String toString() {
            return ReflectionToStringBuilder.toString(this,ToStringStyle.JSON_STYLE);
        }
    }

}
