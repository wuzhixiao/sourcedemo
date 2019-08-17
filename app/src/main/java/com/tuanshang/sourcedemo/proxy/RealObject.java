package com.tuanshang.sourcedemo.proxy;

import android.util.Log;

//被代理类
public class RealObject implements AbstractObject {

    @Override
    public void operation() {
        Log.i("Proxy", "RealObject: operation()");
    }
}
