package com.javalearning.math;

import org.apache.commons.lang3.math.Fraction;

/**
 * Created by renqun.yuan on 2015/11/3.
 */
public class FractionExample {
    public static void main(String[] args) {
        Fraction fraction = Fraction.getFraction(1, 3, 4);
        double value = fraction.doubleValue();
        System.out.println(value);
    }
}
