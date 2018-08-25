package org.lf.invocationhandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liufu
 */
public class InvocationHandlerImpl implements InvocationHandler {

    private Object obj;

    public InvocationHandlerImpl(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(obj, args);
        return null;
    }
}
