
package com.bonc.example.demo.io;

import java.io.File;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @version 2019年10月19日
 * @see Demo4
 * @since
 */

public class Demo4 {

    public static void main(String[] args) throws Exception {
//        StringBuffer sb = new StringBuffer();
//        Set<String> a = new HashSet<>();
//        a.add("a");
//        a.add("b");
//        a.add("c");
//        a.add("d");
//        a.add("e");
//
//        Set<String> b = a;
//        Iterator<String> i1 = b.iterator();
//
//        while (i1.hasNext()){
//            i1.next();
//            i1.remove();
//        }
//        a = b;
//        sb.append(a);
//        System.out.println(sb.toString());
//        byte[] data =new byte[4];
//        Queue<byte[]> queue = new PriorityQueue<>();//队列，排队，先排队的先出来办理，
//        if (queue.size()<100){
//            queue.add(data);
//        }else {
//            queue.poll();//第一个被拿出来，
//            queue.add(data);
//        }
//        for (int i = 0; i < queue.size(); i++) {
//            Iterator<byte[]> iterator = queue.iterator();//编辑器
//            if (iterator.hasNext()) {//加入还有下一个，就往下编辑
//                byte[] next = iterator.next();
//                iterator.remove();
//            }
//        }
//        System.out.println(queue.size());
//        String[] nums = "172.16.13.133".split("/.");
//        String brokerId = nums[3];
//        System.out.println(brokerId);
//        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("heartbeat-processor-%d").build();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        executor.scheduleAtFixedRate(

                new MyThread(),

                0,

                1000,

                TimeUnit.MILLISECONDS);

    }


//        sb.append("aaaaaaaaaaaaaaaaaaa\naffffff");
//        //FileUtils.writeLines(new File("F:\\test\\hosts"), newLines,true);
//        FileUtils.writeStringToFile(new File("D:\\1234.txt"), sb.toString(),true);
static class MyThread implements Runnable{

    @Override
    public void run() {
//        while (true) {
            System.out.println(Thread.currentThread().getName() + "=========" + System.currentTimeMillis());
//        }
    }
}

    static void aaa(int a){
        a++;
    }

}
