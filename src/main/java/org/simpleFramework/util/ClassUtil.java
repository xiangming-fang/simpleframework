package org.simpleFramework.util;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: simpleframework
 * @Package: org.simpleFramework.util
 * @ClassName: ClassUtil
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/11 19:00
 */
@Slf4j
public class ClassUtil {

    private static final String FILE_PROTOCOL = "file";

    /**
     * 获取包下类集合
     *
     * @param packageName 包路径
     * @return 类集合
     */
    public static Set<Class<?>> extractPackageClass(String packageName){

        // 1、获取到类的加载器
        ClassLoader classLoader = getClassLoader();

        // 2、通过类加载器获取到加载的资源
        URL url = classLoader.getResource(packageName.replace(".","/"));
        if (url == null) {
            log.warn("unable to retrieve anything from package: " + packageName);
            return null;
        }

        // 3、依据不同的资源类型，采用不同的方式获取资源的集合
        Set<Class<?>> classSet = null;
        // 过滤出文件类型的资源
        if (url.getProtocol().equalsIgnoreCase(FILE_PROTOCOL)){
            classSet = new HashSet<>();
            File packageDirectory = new File(url.getPath());
            extractClassFile(classSet,packageDirectory,packageName);
        }
        return classSet;
    }

    /**
     * 递归获取目标package里面的所有class文件（包括package里的class文件）
     *
     * @param emptyClassSet 装载目标类的集合
     * @param fileSource 文件或目录
     * @param packageName 包名
     */
    private static void extractClassFile(Set<Class<?>> emptyClassSet, File fileSource, String packageName) {
        if (!fileSource.isDirectory()){
            return;
        }
        File[] files = fileSource.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                } else {
                    // 获取文件的绝对值路径
                    String absoluteFilePath = file.getAbsolutePath();
                    if (absoluteFilePath.endsWith(".class")) {
                        // 若是class文件，则直接加载
                        addToClassSet(absoluteFilePath);
                    }
                }
                return false;
            }

            // 根据class文件的绝对值路径，获取并生成class对象，并放入classSet中
            private void addToClassSet(String absoluteFilePath) {
                // 1、从class文件的绝对值路径汇总提取出包含了package的类名
                // eg: e://www//xm//jy//hello.class 改变成 xm.jy.hello
                absoluteFilePath = absoluteFilePath.replace(File.separator,".");
                String className = absoluteFilePath.substring(absoluteFilePath.indexOf(packageName));
                className = className.substring(0,className.lastIndexOf("."));

                // 2、通过反射机制获取对应的Class对象，并加入到classSet里
                Class<?> targetClass = loadClass(className);
                emptyClassSet.add(targetClass);
            }
        });
        if (files != null){
            for (File file : files) {
                extractClassFile(emptyClassSet,file,packageName);
            }
        }
    }

    /**
     * 获取Class对象
     * @param className
     * @return
     */
    public static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            log.error("获取class对象异常");
        }
        return null;
    }

    /**
     * 获取classLoader
     *
     * @return 当前类加载器
     */
    public static ClassLoader getClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    public static void main(String[] args) {
        extractPackageClass("indi.xm.entity");
    }
}
