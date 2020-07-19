package com.bonc.example.demo.proxy;

/**
 * @author luoaojin
 * @CreateTime 2019-02-21
 * @Description
 */
public class NetProxy implements Network {
    private RealNet realNet;
    @Override
    public void browse() {
        check();
        realNet.browse();
    }

    public NetProxy(RealNet realNet) {
        this.realNet = realNet;
    }
    public void check(){
        System.out.println("检查用户是否合法");
    }
}
