package com.ahao.spring.boot.core.io;

import java.io.*;
import java.util.*;

/**
 * @author ahao
 * @since 2019/8/25 20:23
 **/
public class FileTest {
    public static void main(String[] args) {
        charCount();
    }

    /**
     * count frequency of character in the pom.xml and sort
     * */
    private static void charCount() {
        Map<Character, Integer> map = new TreeMap<>();
        try (Reader reader = new FileReader("pom.xml")) {
            int data;
            while ((data = reader.read()) != -1) {
                char aa = (char) data;
                Integer result = map.get(aa);
                if (null == result) {
                    map.put(aa, 1);
                } else {
                    map.put(aa, ++result);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // map.forEach((k, v) -> System.out.println("key : " + k + " -> value : " + v));
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        list.stream().forEach(entry -> System.out.println("key : " + entry.getKey() + " -> value : " + entry.getValue()));
    }
}
