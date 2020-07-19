package com.bonc.example.demo.system;

import com.bonc.example.demo.B;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author luoaojin
 * @CreateTime 2019-03-08
 * @Description
 */
public class Test1 {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Book b1= new Book("a",12);
        Book b2= new Book("ar",122);
        Book b3= new Book("ae",412);
        Book b4= new Book("ab",2);
        List<Book> books = new ArrayList<>();
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);

//        Book[] objects =  books.toArray(new Book[]{});
//        Arrays.sort(objects);
        books.sort((o1, o2) -> {
            if (o1.getPrice() > o2.getPrice()){
                return 1;
            }else if(o1.getPrice() < o2.getPrice()){
                return -1;
            }else {
                return 0;
            }

        });
        Constructor<?>[] constructors = Book.class.getConstructors();

//        System.out.println(constructors[1].newInstance());
        Book book = Book.class.newInstance();
        Field name = Book.class.getDeclaredField("name");

        name.setAccessible(true);
        name.set(book,"lalsdw");
        System.out.println(book.getName());

//        for (Book book : books) {
//            System.out.println(book);
//        }

    }
}
