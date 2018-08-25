package org.lf.app;

import java.util.Arrays;

/**
 * @author liufu
 */
public class App {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        System.out.println(App.class.getClassLoader());
        System.out.println(App.class.getClassLoader().getResource("").toString());
        Class<?> aClass = classLoader.loadClass("org.lf.app.Dog");
        System.out.println(Arrays.toString(aClass.getDeclaredMethods()));
    }
}
