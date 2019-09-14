package com.ahao.spring.boot.core.lambda;

import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

/**
 * @author ahao
 * @since 2019/8/22 21:44
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println(toUpperOrLowerCase("jfafiorh", str -> str.substring(2, 4)));
        testConsumer("My name is ahao!", str -> System.out.println(str));
        Set<Integer> set = new TreeSet<>();
        set.add(6);
        set.add(3);
        set.add(36);
        set.add(5);
        System.out.println(set);
    }

    private static String toUpperOrLowerCase(String str, MyFunction myf) {
        return myf.getValue(str);
    }

    private static void testConsumer(String str, Consumer<String> consumer) {
        consumer.accept(str);
    }

}
