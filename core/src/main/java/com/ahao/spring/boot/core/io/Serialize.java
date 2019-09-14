package com.ahao.spring.boot.core.io;

import java.io.*;

/**
 * @author ahao
 * @since 2019/8/26 21:25
 **/
public class Serialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serial();
        deSerial();
    }

    private static void serial() throws IOException {
        Person ahao = new Person("ahao", 18);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.dat"));
        objectOutputStream.writeObject(ahao);
        objectOutputStream.flush();
    }

    private static void deSerial() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.dat"));
        Object object = objectInputStream.readObject();
        System.out.println(object);
    }
}

class Person implements Serializable {

    private static final long serialVersionUID = 7641171967420954407L;

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
