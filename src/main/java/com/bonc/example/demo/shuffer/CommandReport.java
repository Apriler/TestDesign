package com.bonc.example.demo.shuffer;

import lombok.Data;

/**
 * @author luoaojin
 * @CreateTime 2020-07-02
 * @Description
 */
@Data
public class CommandReport {
//    taskId:319, status:IN_PROGRESS, instanceType:QuorumPeerMain, roleCommand:START
    int taskId;
    HostRoleStatus status;
    InstanceType instanceType;
    RoleCommand roleCommand;

    public CommandReport(int taskId, HostRoleStatus status, InstanceType instanceType, RoleCommand roleCommand) {
        this.taskId = taskId;
        this.status = status;
        this.instanceType = instanceType;
        this.roleCommand = roleCommand;
    }
}
