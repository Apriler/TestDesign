package com.bonc.example.demo.proxy;

/**
 * @author luoaojin
 * @CreateTime 2019-02-21
 * @Description
 */
public class RealNet implements Network {
    @Override
    public void browse() {
        System.out.println("上网啦");
    }
}
