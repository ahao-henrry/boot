package com.ahao.spring.boot.core.reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author ahao
 * @since 2019/8/27 19:37
 **/
public class MyReflection {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Flour> flourClass = Flour.class;
        System.out.println(flourClass.getPackage());
        Flour flour = flourClass.newInstance();
        System.out.println(flour);

        Constructor<Flour> constructor = flourClass.getConstructor(String.class);
        Flour jasmine = constructor.newInstance("jasmine");
        System.out.println(jasmine);

        Constructor<Flour> constructor1 = flourClass.getDeclaredConstructor(String.class, String.class);
        constructor1.setAccessible(true);
        Flour violet = constructor1.newInstance("violet", "purple");
        System.out.println(violet);

        Method[] declaredMethods = flourClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

    private void getResource() throws IOException {
        this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        this.getClass().getResourceAsStream("jdbc.properties");

        Properties properties = new Properties();
        properties.load(new FileInputStream("jdbc.properties"));
        properties.getProperty("url");
    }
}
