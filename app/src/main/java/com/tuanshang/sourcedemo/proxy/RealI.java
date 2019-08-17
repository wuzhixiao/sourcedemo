package com.tuanshang.sourcedemo.proxy;

import android.util.Log;

//被代理类
public class RealI implements IAbstract {

    @Override
    public void operation() {
//        Log.i("Proxy", "RealI: operation()");
        System.out.println("RealI: operation()");
    }
}
