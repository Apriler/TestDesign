package com.bonc.example.demo.enumtest;

/**
 * @author luoaojin
 * @CreateTime 2019-02-26
 * @Description
 */
@FunctionalInterface
public interface Print {

    public void print();

    default String aa(){
      return "aaaa";
    }
}
