package com.bonc.example.demo.shuffer;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luoaojin
 * @CreateTime 2020-07-02
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        List<CommandReport> c = new ArrayList<>();
        ////CommandReport(taskId:319, status:IN_PROGRESS, instanceType:QuorumPeerMain, roleCommand:START),
        ////CommandReport(taskId:328, status:IN_PROGRESS, instanceType:HDFSClient, roleCommand:START),
        ////CommandReport(taskId:335, status:IN_PROGRESS, instanceType:Flink_Client, roleCommand:START),
        ////CommandReport(taskId:341, status:IN_PROGRESS, instanceType:Spark_Client, roleCommand:START),
        ////CommandReport(taskId:335, stdout:, status:COMPLETED, instanceType:Flink_Client, roleCommand:START),
        ////CommandReport(taskId:341, stdout:, status:COMPLETED, instanceType:Spark_Client, roleCommand:START),
        ////CommandReport(taskId:328, stdout:, status:COMPLETED, instanceType:HDFSClient, roleCommand:START),
        ////CommandReport(taskId:319, stdout:, status:COMPLETED, instanceType:QuorumPeerMain, roleCommand:START)])
        c.add(new CommandReport(319,HostRoleStatus.IN_PROGRESS,InstanceType.QUORUMPEERMAIN,RoleCommand.START));
        c.add(new CommandReport(328,HostRoleStatus.IN_PROGRESS,InstanceType.HDFSCLIENT,RoleCommand.START));
        c.add(new CommandReport(335,HostRoleStatus.IN_PROGRESS,InstanceType.FLINKCLIENT,RoleCommand.START));
        c.add(new CommandReport(341,HostRoleStatus.IN_PROGRESS,InstanceType.SPARKCLIENT,RoleCommand.START));

        c.add(new CommandReport(319,HostRoleStatus.COMPLETED,InstanceType.QUORUMPEERMAIN,RoleCommand.START));
        c.add(new CommandReport(328,HostRoleStatus.COMPLETED,InstanceType.HDFSCLIENT,RoleCommand.START));
        c.add(new CommandReport(335,HostRoleStatus.COMPLETED,InstanceType.FLINKCLIENT,RoleCommand.START));
        c.add(new CommandReport(341,HostRoleStatus.COMPLETED,InstanceType.SPARKCLIENT,RoleCommand.START));
        filter(c);
    }

    static void filter(List<CommandReport> c){
        Map<Integer,HostRoleStatus> cache = new HashMap<>();
        for (int i = c.size() - 1; i >= 0; i--) {
            if (!StringUtils.isEmpty(cache.get(c.get(i).getTaskId()))){
                System.out.println("taskId --- 》 已被处理 ："+c.get(i).getTaskId());
                continue;
            }
            System.out.println("deal --->"+c.get(i));
            cache.put(c.get(i).getTaskId(),c.get(i).getStatus());
        }
    }
}
