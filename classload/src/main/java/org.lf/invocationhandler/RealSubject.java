package org.lf.invocationhandler;

/**
 * @author liufu
 */
public class RealSubject implements Subject {

    @Override
    public void request(String name) {
        System.out.println("From real subject." + name);
    }
}
