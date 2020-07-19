package com.bonc.example.demo.system;

import lombok.Data;

import java.util.Comparator;

/**
 * @author luoaojin
 * @CreateTime 2019-03-08
 * @Description
 */
@Data
public class Book implements Comparator<Book> {
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    private String name;
    private int price;

    public Book() {
    }

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }



    @Override
    public int compare(Book o1, Book o2) {
        if (o1.price > o2.price){
            return 1;
        }else if(o1.price < o2.price){
            return -1;
        }else {
            return 0;
        }
    }
}
