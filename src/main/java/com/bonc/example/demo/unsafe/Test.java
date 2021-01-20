package com.bonc.example.demo.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author luoaojin
 * @Date 2020/9/8 14:35
 * @Description
 * @Version 1.0
 */
public class Test {

    static Unsafe unsafe ;

    static long stateOffset;

    public volatile long state = 0;

    static {
//        try {
////            stateOffset  = unsafe.objectFieldOffset(Test.class.getDeclaredField("l"));
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
            stateOffset = unsafe.objectFieldOffset(Test.class.getDeclaredField("state"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args)  {
        Test t =new Test();
        System.out.println(unsafe.compareAndSwapLong(t, stateOffset, 0, 1));
    }
}
