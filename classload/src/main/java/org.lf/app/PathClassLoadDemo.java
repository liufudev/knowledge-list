package org.lf.app;

import java.util.Arrays;

/**
 * @author liufu
 */
public class PathClassLoadDemo {

    public static void main(String[] args) throws Exception {
        PathClassLoad classLoad = new PathClassLoad("org.lf.app.Dog");
        Class<?> aClass = classLoad.findClass("org");
        System.out.println(Arrays.toString(aClass.getDeclaredMethods()));
    }
}
