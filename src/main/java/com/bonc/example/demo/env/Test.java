package com.bonc.example.demo.env;

import java.util.Map;

/**
 * @Author luoaojin
 * @Date 2021/3/10 17:38
 * @Description
 * @Version 1.0
 */
public class Test {
    private static final SystemEnvironment sysenv = new SystemEnvironment();
    public static void main(String[] args) {
        Map<String, String> env = sysenv.getenv();
        System.out.println("------------------------");
        for (Map.Entry<String, String> entry : env.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    static class SystemEnvironment {
        public String getenv(final String name) {
            return System.getenv(name);
        }

        public Map<String, String> getenv() {
            return System.getenv();
        }
    }
}
