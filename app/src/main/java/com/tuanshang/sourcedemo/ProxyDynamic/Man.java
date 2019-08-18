package com.tuanshang.sourcedemo.ProxyDynamic;

//被代理类
public class Man implements ISubject {
    @Override
    public void shopping() {
        System.out.println("Man ：Man Shopping");
    }
}
