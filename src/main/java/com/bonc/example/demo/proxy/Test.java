package com.bonc.example.demo.proxy;

/**
 * @author luoaojin
 * @CreateTime 2019-02-21
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        Network network = new NetProxy(new RealNet());
        network.browse();
    }
}
