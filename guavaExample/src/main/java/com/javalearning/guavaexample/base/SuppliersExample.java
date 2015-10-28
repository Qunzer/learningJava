package com.javalearning.guavaexample.base;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import java.util.concurrent.TimeUnit;

/**
 * Created by renqun.yuan on 2015/7/17.
 */
public class SuppliersExample {
    private static final Supplier<String> supplier = new Supplier<String>() {
        @Override
        public String get() {
            System.out.println("supplier get invoke");
            return "supplier";
        }
    };

    public static void main(String[] args) throws InterruptedException {
        Supplier<String> memoizeSupplier = Suppliers.memoize(supplier);
        System.out.println(memoizeSupplier.get());
        System.out.println(memoizeSupplier.get());

        System.out.println("=====================");

        Supplier<String> memoizeWithExpiration = Suppliers.memoizeWithExpiration(supplier, 100, TimeUnit.MICROSECONDS);
        System.out.println(memoizeWithExpiration.get());
        System.out.println(memoizeWithExpiration.get());
        System.out.println(memoizeWithExpiration.get());
    }
}
