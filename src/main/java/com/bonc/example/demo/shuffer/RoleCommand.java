/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bonc.example.demo.shuffer;

public enum RoleCommand {

    /*
     * When adding/modifying enum members, please beware that except Java usages,
     * RoleCommand string representations are used at role_command_order.json
     * files
     */
    //安装
    INSTALL,
    //格式化
    FORMAT,
    //同步
    SYNC,
    //卸载
    UNINSTALL,
    //启动
    START,
    //重启
    RESTART,
    //停止
    STOP,
    //执行
    EXECUTE,
    //取消
    ABORT,
    //升级
    UPGRADE,
    //服务检查
    SERVICE_CHECK,

    //添加服务时，只需要执行ranger的plugin脚本
    EXECUTE_PLUGIN,
    
    //dataNode下线
    DATANODE_OFFLINE,
    
    //dataNode上线
    DATANODE_ONLINE,
    
    //hdfs刷新节点
    REFRESH_NODES,
    
    //集群扩容时，旧的主机需要分发集群主机列表及hadoop.keytab、hadoop.keystore
    HAND_OUT,
    
    //集群扩容时，扩容的主机安装
    HOST_INSTALL,

    /**
     * Represents any custom command
     */
    //自定义
    CUSTOM_COMMAND,

    /**
     * Represents any action
     */
    //ACTIONEXECUTE
}
