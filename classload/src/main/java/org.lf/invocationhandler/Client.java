package org.lf.invocationhandler;

import java.lang.reflect.Proxy;

/**
 * @author liufu
 */
public class Client {

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Class<? extends Subject> aClass = subject.getClass();
        Subject proxyInstance = (Subject) Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), (proxy, method, param) ->
                                                                 {
                                                                     System.out.println("my name is liufu");
                                                                     method.invoke(subject, param);
                                                                     return null;
                                                                 }


        );
        proxyInstance.request("liufu");
        System.out.println("subject的Class类是：" + proxyInstance.getClass().toString());
        System.out.print("subject中的属性有：");
    }
}
