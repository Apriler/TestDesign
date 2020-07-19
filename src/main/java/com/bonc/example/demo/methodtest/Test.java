package com.bonc.example.demo.methodtest;

import org.springframework.util.StringUtils;

import java.awt.*;
import java.util.function.Function;

/**
 * @author luoaojin
 * @CreateTime 2019-02-26
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        Function<Integer,String> function = String::valueOf;
        IMessage<Book> book = Book::new;
        Book aa = book.add("aa");
//        function.apply(111).var
    }
}
