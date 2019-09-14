package com.ahao.spring.boot.core.reflection;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author ahao
 * @since 2019/8/27 19:37
 **/
public class Flour {

    @Value("sds")
    private String name;

    public String color;

    public Flour() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Flour(String name) {
        this.name = name;
    }

    private Flour(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void showName() {
        System.out.println("Hi, im " + this.name);
    }

    public String showAndGetName() {
        System.out.println("Hi, im " + this.name);
        return this.name;
    }

    @Override
    public String toString() {
        return "Flour{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
