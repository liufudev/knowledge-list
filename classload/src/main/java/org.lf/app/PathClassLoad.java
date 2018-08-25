package org.lf.app;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author liufu
 */
public class PathClassLoad extends ClassLoader {

    private String classPath;

    public PathClassLoad(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (classPath.startsWith(name)) {
            byte[] data = getData(name);
            if (data == null) {
                throw new ClassNotFoundException();
            } else {
                return defineClass(name, data, 0, data.length);
            }
        } else {
            return super.loadClass(name);
        }
    }

    private byte[] getData(String className) {
        String path = classPath + File.separator + className.replace('.', File.separatorChar) + ".class";
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[2048];
            int num;
            if ((num = inputStream.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes, 0, num);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
