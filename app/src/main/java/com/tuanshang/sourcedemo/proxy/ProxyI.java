package com.tuanshang.sourcedemo.proxy;

import android.util.Log;

//代理类
public class ProxyI implements IAbstract {

    //被代理类
    RealI mRealObject;

    public ProxyI(RealI mRealObject) {
        this.mRealObject = mRealObject;
    }

    @Override
    public void operation() {
        if (mRealObject == null) {
            mRealObject = new RealI();
        }
        //在代理类里面对被代理类调用operation()方法前后可以加更多逻辑限制。
        //例如：在开发过程中，想要对原有对方法做改进，方法一：直接改原来对方法，方法二：调用代理类，对产生对结果进行控制，这就是代理模式
        mRealObject.operation();
        System.out.println("ProxyI: operation()");

    }
}
