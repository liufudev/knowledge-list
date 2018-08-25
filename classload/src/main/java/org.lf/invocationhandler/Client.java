package org.lf.invocationhandler;

import java.lang.reflect.Proxy;

/**
 * @author liufu
 */
public class Client {

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        InvocationHandlerImpl handler = new InvocationHandlerImpl(subject);
        Class<? extends Subject> aClass = subject.getClass();
        Subject proxyInstance = (Subject) Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), handler);
        proxyInstance.request("liufuy");
    }
}
