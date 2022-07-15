package com.bonc.example.demo.string;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author luoaojin
 * @CreateTime 2020-07-13
 * @Description
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
//        int stageId = 1;
//        long end = System.currentTimeMillis();
//        long requestId = 108L;
//
//        StringBuilder dataSql = new StringBuilder("UPDATE host_role_command hrc SET hrc.`status` = CASE ");
//        dataSql.append(" WHEN hrc.stage_id = '").append(stageId).append("' THEN '").append(HostRoleStatus.FAILED.toString()).append("' ");
//        dataSql.append(" WHEN hrc.stage_id > '").append(stageId).append("' THEN '").append(HostRoleStatus.ABORTED.toString()).append("' ");
//        dataSql.append(" ELSE hrc.`status` ");
//        dataSql.append(" END, ");
//        dataSql.append(" hrc.end_time = CASE ");
//        dataSql.append(" WHEN hrc.stage_id >= '").append(stageId).append("' THEN '").append(end).append("' ");
//        dataSql.append(" ELSE hrc.end_time ");
//        dataSql.append(" END ");
//        dataSql.append(" WHERE hrc.request_id = '").append(requestId).append("'");
//
//        System.out.println(dataSql.toString());

//        System.out.println(TimeUnit.MINUTES.toMillis(2));
        List<String> a = new ArrayList<>();
        File file = new File("D:\\workspace2\\bdd\\bdds\\a.txt");
        FileOutputStream out=new FileOutputStream(file);
        StringBuilder content = new StringBuilder();
        for (int j = 0; j <= 3000; j++) {
//            String agent_id = j + "";
//            content.append("INSERT INTO `beh_bdds_luo`.`agent_node`(`agent_id`, `agent_pid`, `cluster_id`, " +
//                    "`create_time`, `deploy_status`, `execute_error`, `execute_status`, `host`, `ip`, `is_available`, `port`, `password`, `runtime_status`, `tenant_id`, " +
//                    "`update_time`, `user`, `user_id`, `work_dir`, `rack`, `arch`, `kernel_version`, `system_type`, `system_version`, `system_version_info`, `disk_total`, `cpu_num`, `memory_total`) VALUES " +
//                    "('"+j+"', '11918', '2c908d0d76d13a490176e006b41508bb', '2020-08-28 18:07:32', 'DEPLOYED', '', 'DONE', '"+j+".bonc.com', '1.1.1."+j+"', b'1', '22', 'C2190D0A10E28BC30F66ADEE43E8AB24', 'RUNNING', 'tenant_system', '2021-01-15 15:45:55', 'bdc', NULL, '/opt', '/default-rack', 'amd64', '3.10.0-957.el7.x86_64', 'CentOS Linux', '7.6.1810', '7.6.1810 (Core) build 3.10.0-957.el7.x86_64', 268338466816, NULL, NULL);\n");
//            content.append("INSERT INTO `beh_bdds_luo`.`bdd_instance`(`instance_id`, `agent_id`, `create_time`, `format_flag`, `identity`, `instance_status`," +
//                    " `role_id`, `service_id`, `type`, `update_time`, `proxy_address`) VALUES " +
//                    "('2c908d"+j+"', '"+j+"', '2021-01-05 18:40:31', NULL, 'follower', 'Running', '2c908d0d76d13a490176d21bdf6004d1', '2c908d0d76d13a490176e01a76780a29', 'QuorumPeerMain', '2021-01-05 18:40:31', NULL);" +
//                    "\n");
            content.append("INSERT INTO `beh_bdds_luo`.`bdd_instance`(`instance_id`, `agent_id`, `create_time`, `format_flag`, `identity`, `instance_status`," +
                    " `role_id`, `service_id`, `type`, `update_time`, `proxy_address`) VALUES " +
                    "('2c908d"+j+"aaa"+j+"', '"+j+"', '2021-01-05 18:40:31', NULL, NULL, 'Terminate', '2c908d0d76d13a490176e00ce5e708be', '2c908d0d76d13a490176e01a74e90a23', 'HiveServer2', '2021-01-05 18:40:31', NULL);" +
                    "\n");
        }
        out.write(content.toString().getBytes());

    }

}
