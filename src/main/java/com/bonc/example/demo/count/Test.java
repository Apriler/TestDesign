package com.bonc.example.demo.count;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author luoaojin
 * @Date 2021/10/18 16:49
 * @Description
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("1");
        restart(a,2,0,0);
    }
    private static void restart(List<String> bddInstanceList, int count, int waitTime, int failures) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.addAll(bddInstanceList);
        int merchant = queue.size() / count;
        int remainder = queue.size() % count;
        int num = 0;
        if (merchant == 0) {
            num++;
        } else if (merchant > 0 && remainder == 0) {
            num = merchant;
        } else if (merchant > 0 && remainder > 0) {
            num = merchant + 1;
        }
        int currentNum = 1 ;
        lable:
        for (int j = 0; j < num; j++) {
            List<String> list = new ArrayList<>();
            queue.drainTo(list, count);
            //重启
//            LOG.info("-----开始重启------");
            for (int current = 0; current < list.size(); current++) {
                System.out.println(currentNum + " / " + bddInstanceList.size());
//                buildStageAndSendQueue(list.get(current), RoleCommand.RESTART, InstanceStatus.Restarting,current,bddInstanceList.size());
                currentNum++;
            }
            //检查重启状态
//            boolean checkStatus = checkStatus(list, failures);


        }

    }
}
