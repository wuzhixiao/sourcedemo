package com.tuanshang.sourcedemo.ProxyDynamic;


public class ProxyTest {
    public static void main(String[] args) {
        //被代理者
        ISubject man = new Man();
        //代理者
        Proxy proxy = new Proxy(man);

        //首先我们解释一下为什么我们这里可以将其转化为Subject类型的对象？
        //原因就是在newProxyInstance这个方法的第二个参数上，我们给这个代理对象proxy提供了一组什么接口，那么我这个代理对象proxy就会实现了这组接口，
        //这个时候我们当然可以将这个代理对象强制类型转化为这组接口中的任意一个，因为这里的接口是ISubject类型，所以就可以将其转化为ISubject类型了。
        ISubject subject = (ISubject) java.lang.reflect.Proxy
                .newProxyInstance(man.getClass().getClassLoader(), man.getClass().getInterfaces(), proxy);

        System.out.println("ProxyTest " + subject.getClass().getName());
        //代理对象调用接口方法时，会关联到InvocationHandler到invoke中的方法去执行
        subject.shopping();

    }
}
