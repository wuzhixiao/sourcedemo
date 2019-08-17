package com.tuanshang.sourcedemo.proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //
        RealI realObject = new RealI();
        ProxyI father = new ProxyI(realObject);
        father.operation();
    }

}
