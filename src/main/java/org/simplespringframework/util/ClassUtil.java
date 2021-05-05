package org.simplespringframework.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class ClassUtil {

    private static final String FILE_PROTOCOL = "file";

    /**
     * 1.获取到类的加载器
     * 2.通过类加载器获取到加载的资源信息
     * 3.依据不同的资源类型，采用不同的方式获取资源的集合
     *
     * @param packageName
     * @return
     */
    public static Set<Class<?>> extractPackageClass(String packageName) {
        ClassLoader classLoader = getClassLoader();
        URL url = classLoader.getResource(packageName.replace(".", "/"));
        if (url == null) {
            log.warn("获取不到信息，pageName:" + packageName);
            return null;
        }
        Set<Class<?>> classSet = null;
        if (url.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)) {
            classSet = new HashSet<>();
            File packageDirectory = new File(url.getPath());
            extractClassFile(classSet, packageDirectory, packageName);
        }
        return null;
    }

    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    private static void extractClassFile(Set<Class<?>> classSet, File packageDirectory, String packageName) {
        if (!packageDirectory.isDirectory()) {
            return;
        }
        File[] files = packageDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                } else {
                    // 获取文件的绝对值路径
                    String absolutePath = file.getAbsolutePath();
                    if (absolutePath.endsWith(".class")) {
                        addToClassSet(absolutePath);
                    }
                }
                return false;
            }

            /**
             * 根据class文件的绝对值路径，获取并生成class对象，并放入classSet中
             * @param absolutePath class文件的绝对值路径
             */
            private void addToClassSet(String absolutePath) {
                absolutePath = absolutePath.replace(File.separator, "");
                String className = absolutePath.substring(absolutePath.indexOf(packageName));
                className = className.substring(0, className.indexOf("."));
                // 通过反射机制
            }
        });

        if (files != null) {
            for (File file : files) {
                extractClassFile(classSet, file, packageName);
            }
        }
    }

    /**
     * @param clazz      Class
     * @param <T>        class的类型
     * @param accessible 是否支持创建出私有class对象的实例
     * @return 类的实例化
     */
    public static <T> T newInstance(Class<?> clazz, boolean accessible) {
        try {
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
            declaredConstructor.setAccessible(accessible);
            return (T) declaredConstructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
