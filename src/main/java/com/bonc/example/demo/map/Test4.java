package com.bonc.example.demo.map;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author luoaojin
 * @Date 2022/3/16 15:10
 * @Description
 * @Version 1.0
 */
public class Test4 {
    public static void main(String[] args) {
        Map<String, Map<String, Map<String, String>>> hostRoleCommands =
                new TreeMap<String, Map<String, Map<String, String>>>();
        if (!hostRoleCommands.containsKey("host2")) {
            // hostRoleCommands.put(hostname, new LinkedHashMap<String, HostRoleCommand>());
            hostRoleCommands.put("host2", new LinkedHashMap<String, Map<String, String>>());
        }
        Map<String, String> rcMap = hostRoleCommands.get("host2").get("ZK");
        if (StringUtils.isEmpty(rcMap)){
            rcMap = new HashMap<>();
        }
        rcMap.put("ZK", "command");
//        hostRoleCommands

    }
}
