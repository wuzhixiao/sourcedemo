package com.tuanshang.sourcedemo.ProxyDynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//代理类

//动态代理的代理类 必须要实现InvocationHandler接口，并且每个代理类的实例都关联到了一个handler。
//代理对象调用程序的时候，一定要实现的接口，
// 当通过代理对象调用方法的时候，
// 这个方法就会把他指派到InvocationHandler的invoke(Object proxy, Method method, Object[] args)上
public class Proxy implements InvocationHandler {

    private Object target;//要代理的真实对象

    public Proxy(Object target) {
        this.target = target;
    }

    //Object proxy:　　指代我们所代理的那个真实对象（真实对象就是被代理对象）
    //Method method:　　指代的是我们所要调用真实对象的某个方法的Method对象
    //Object[] args:   指代的是调用真实对象某个方法时接受的所有参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy ：" + proxy.getClass().getName());
        System.out.println("proxy ：method： " + method);

        //在代理真实对象前我们可以添加一些自己的操作
        System.out.println("proxy ：在代理真实对象前我们可以添加一些自己的操作");

        //当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        method.invoke(target, args);

        //在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("proxy ：在代理真实对象后我们也可以添加一些自己的操作");
        return null;
    }
}
