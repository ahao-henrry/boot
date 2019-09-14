package com.ahao.spring.boot.core.coll.List;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet usage
 *
 * @author ahao
 * @since 2019/8/25 10:54
 **/
public class Book implements Comparable<Book> {
    private String name;
    private Double price;

    public Book(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        Set<Book> books = new TreeSet((Comparator<Book>) (o1, o2) -> {
            int result = (int) (o1.price - o2.price);
            if (0 != result) {
                return (int) (o1.price - o2.price);
            }

            return o1.name.compareTo(o2.name);
        });

        books.add(new Book("java", 12D));
        books.add(new Book("python", 6D));
        books.add(new Book("linux", 6D));
        books.add(new Book("spring", 5D));

        for (Book book : books) {
            System.out.println(book.toString());
        }

    }

    @Override
    public int compareTo(Book o) {
        return this.name.compareTo(o.name);
        // return this.price.compareTo(o.price);
    }
}
