package com.bonc.example.demo.trycatch;

/**
 * @Author luoaojin
 * @Date 2021/4/20 9:29
 * @Description
 * @Version 1.0
 */
public class People {
    private String name;
    private String job;
    private String loved;

    public People(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
