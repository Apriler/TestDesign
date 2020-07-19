package com.bonc.example.demo.string;

import java.util.concurrent.TimeUnit;

/**
 * @author luoaojin
 * @CreateTime 2020-07-13
 * @Description
 */
public class Test2 {
    public static void main(String[] args) {
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

        System.out.println(TimeUnit.MINUTES.toMillis(2));
    }
}
