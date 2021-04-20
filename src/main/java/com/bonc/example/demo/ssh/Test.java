package com.bonc.example.demo.ssh;

import com.jcraft.jsch.Session;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author luoaojin
 * @Date 2021/1/28 16:36
 * @Description
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        SshUtils utils = new SshUtils("172.16.13.141", 33, "bdc",
                "bdc123", null);

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
        String agentStartCmd = "sudo su - hadoop; /opt/bdd-agent/sbin/bdda-daemon.sh stop" ;
//        String agentStartCmd = "sudo ls /" ;

        Session session = null;
        try {
            //设置agent为启动中
//            this.updateRuntimeStatus(agentId, AgentRuntimeStatus.STARTING.getContent());
            session = utils.getSession();
//            LOGGER.info("------在 {} 主机上 执行 {} 命令 ------",agentNode.getHost(),agentStartCmd);
            utils.getShellResult(session, "arch");
        } catch (Exception e) {
//            this.updateRuntimeStatus(agentId, AgentRuntimeStatus.ERROR.getContent());
//            LOGGER.error("------启动主机失败，host：{} ,更新状态------", agentNode.getHost());
//            throw new BddsException("Start agentNode failed !", e);
            e.printStackTrace();
        } finally {
            utils.close(null, null, session);
        }
    }
}
