package com.bonc.example.demo.factoryModel;

import com.bonc.example.demo.C;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luoaojin
 * @CreateTime 2020-05-27
 * @Description
 */
public class TestLock2 {





    public static void main(String[] args) {
        Show s = new Show();
        new Thread(() ->{
            for (int i = 0; i < 3; i++) {

                s.print5();
            }
        },"A").start();
        new Thread(() ->{
            for (int i = 0; i < 3; i++) {

                s.print10();
            }
        },"B").start();
        new Thread(() ->{
            for (int i = 0; i < 3; i++) {

                s.print15();
            }
        },"C").start();

    }
}
class Show{
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    int flag = 1;
    void print5(){

        lock.lock();
        try {
            while (flag != 1) {
                c1.await();
            }

            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " +i);
            }
            flag ++;
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();

        }
    }
    void print10(){
        lock.lock();
        try {
            while (flag != 2) {
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " +i);
            }
            flag ++;
            c3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();

        }
    }
    void print15(){

        lock.lock();
        try {
            while (flag != 3) {
                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + " " +i);
            }
            flag = 1;
            c1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


}
