package com.bonc.example.demo.ssh;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author luoaojin
 * @Date 2021/1/28 16:36
 * @Description
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        ThreadFactory threadFactory  = new ThreadFactoryBuilder().setNameFormat("bdds-%d").build();
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(200);
        ThreadPoolExecutor monitorExecutor = new ThreadPoolExecutor(6, Integer.MAX_VALUE,
                60, TimeUnit.SECONDS,
                workQueue,threadFactory);
        AtomicInteger port = new AtomicInteger(33);
        for (int i = 1; i < 3; i++) {
            int finalI = i;
            monitorExecutor.execute(() -> {
                try {
                    deploy(finalI, port.get());
                    port.addAndGet(-11);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

    }

//    private static void deploy(int finalI) {
//        File file = new File("D:\\workspace2\\bdd\\bdda\\target\\bdda-1.3.2-SNAPSHOT-X86_64.tar.gz");
//        try {
//            InputStream ins = new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }

    private static void deploy(int finalI ,int port)  {
        SshUtils utils = new SshUtils("172.16.13.14"+finalI, port, "root",
                "root123", null);

//        String agentStartCmd = "sudo chown -R " + agentNode.getUser() + ":" + agentNode.getUser() + " " + agentNode.getWorkDir() + AgentDirConstruct.LOGS + File.separator
//                + ";sudo "
//                + agentNode.getWorkDir() + AgentDirConstruct.SBIN + File.separator
//                + AgentDirConstruct.DAEMON + " start"
//                + " --eureka.instance.metadata-map.app-key=" + tenementId
//                + " --eureka.instance.metadata-map.agent-ip=" + agentNode.getIp() + ":" + agentPort
//                + " --bdds.server.ip=" + bddsIp
//                + " --eureka.instance.hostname=" + eurekaIp
//                + " --eureka.client.serviceUrl.defaultZone=" + eurekaClientServiceUrlDefaultZone;
//        String agentStartCmd = "sudo chown -R bdc:bdc /opt/bdd-agent/logs/;sudo /opt/bdd-agent/sbin/bdda-daemon.sh start" +
//                " --eureka.instance.metadata-map.app-key=tenant_system --eureka.instance.metadata-map.agent-ip=172.16.13.141:19911" +
//                " --bdds.server.ip=172.16.13.141 --eureka.instance.hostname=beh-1.bonc.com" +
//                " --eureka.client.serviceUrl.defaultZone=http://172.16.13.149:8761/epm-eureka/eureka/";
//        String agentStartCmd = "sudo su - hadoop; /opt/bdd-agent/sbin/bdda-daemon.sh stop" ;
//        String agentStartCmd = "sudo ls /" ;

        Session session = null;
        ChannelSftp sftp = null;
        Channel channel = null;
        try {
            session = utils.getSession();
            channel = utils.getSFTPChannel(session);
            sftp = utils.getSftp(channel);
            utils.pushFile(sftp, "D:\\workspace2\\bdd\\bdda\\target\\bdda-1.3.2-SNAPSHOT-X86_64.tar.gz", "/tmp/");
            String bddaDcpCmd = "echo aaa";
            utils.shell(session, bddaDcpCmd);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            utils.close(null, null, session);
        }
    }
}
