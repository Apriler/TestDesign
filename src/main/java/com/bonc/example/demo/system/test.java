package com.bonc.example.demo.system;

/**
 * @author luoaojin
 * @CreateTime 2019-03-07
 * @Description
 */
public class test {

    static class Person {
        private String name;
        private int age;

        public Person() {
            System.out.println("lalala");
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("我消失了");
        }
    }

    public static void main(String[] args) {
        Person p = new Person();
        p = null;
        System.gc();
    }
}
