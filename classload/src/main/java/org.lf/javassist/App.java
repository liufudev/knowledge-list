package org.lf.javassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * @author liufu
 */
public class App {

    public static void main(String[] args) throws NotFoundException, CannotCompileException {
        replaceMethodBody("org.lf.javassist.Student", "execute", "System.out.println(\"this method is changed dynamically!\");");
        Student student = new Student();
        student.execute();
    }

    public static void replaceMethodBody(String clazzName, String methodName, String newMethodBody) {
        try {
            CtClass clazz = ClassPool.getDefault().get(clazzName);
            CtMethod method = clazz.getDeclaredMethod(methodName);
            method.setBody(newMethodBody);
            clazz.toClass();
        } catch (NotFoundException | CannotCompileException e) {
            throw new RuntimeException(e);
        }
    }
}
