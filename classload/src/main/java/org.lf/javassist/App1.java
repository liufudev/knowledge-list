package org.lf.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

import java.lang.reflect.Method;

/**
 * @author liufu
 */
public class App1 {

    public static void main(String[] args) throws Exception {
        CtClass point = ClassPool.getDefault().get("org.lf.javassist.Point");
        CtMethod m = CtNewMethod.make(
                "public int move(int dx) { x += dx;return x; }",
                point);
        point.addMethod(m);
        Class<?> aClass = point.toClass();
        Object o = aClass.newInstance();
        Method method = aClass.getDeclaredMethod("move", int.class);
        Object result = method.invoke(o, 2);
        System.out.println(result);
    }
}
