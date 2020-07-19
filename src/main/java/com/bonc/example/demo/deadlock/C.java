package com.bonc.example.demo.deadlock;

import com.sun.javaws.Main;

import java.util.Scanner;

/**
 * @author luoaojin
 * @CreateTime 2019-09-26
 * @Description
 */
public class C {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        s.next();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                }
            }
        },"while true").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (new Object()){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"wait").start();
    }

    }
