package org.simpleFramework.core;

import demo.annotation.AnnotationDemo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.simpleFramework.core.annotation.Component;
import org.simpleFramework.core.annotation.Controller;
import org.simpleFramework.core.annotation.Repository;
import org.simpleFramework.core.annotation.Service;
import org.simpleFramework.util.ClassUtil;
import org.simpleFramework.util.ValidationUtil;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ProjectName: simpleframework
 * @Package: org.simpleFramework.core
 * @ClassName: BeanContainer
 * @Author: albert.fang
 * @Description: IOC容器
 * @Date: 2021/11/14 14:04
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class BeanContainer {

    /**
     * 存放所有配置标记的目标对象的map
     */
    private final Map<Class<?>,Object> beanMap = new ConcurrentHashMap();

    /**
     * 加载bean的注解列表
     *
     */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION
            = Arrays.asList(Controller.class, Service.class, Component.class, Repository.class);

    /**
     * 容器是否已经被加载
     */
    private boolean loaded = false;

    public boolean isLoaded(){
        return loaded;
    }

    /**
     * 获取加载bean的个数
     * @return
     */
    public int size(){
        return beanMap.size();
    }

    /**
     * 创建ioc容器对象
     *
     * @return
     */
    public static BeanContainer getInstance(){
        return ContainerHolder.HOLDER.instance;
    }

    private enum ContainerHolder{

        HOLDER;

        private BeanContainer instance;

        ContainerHolder(){
            instance = new BeanContainer();
        }
    }

    /**
     * 扫描加载所有bean
     * 防止多个线程，synchronized
     */
    public synchronized void loadBeans(String packageName){
        if (loaded){
            log.warn("容器已经被加载了");
            return;
        }
        Set<Class<?>> classSet = ClassUtil.extractPackageClass(packageName);
        if (ValidationUtil.isEmpty(classSet)) {
            log.warn("没有扫描到加载目标bean");
            return;
        }
        for (Class<?> clazz : classSet) {
            for (Class<? extends Annotation> annotation : BEAN_ANNOTATION) {
                // 如果类上面有自定义注解
                if (clazz.isAnnotationPresent(annotation)) {
                    // 将目标类本身作为键，目标类的示例作为值,放入beanmap中
                    beanMap.put(clazz,ClassUtil.newInstance(clazz,true));
                }
            }
        }
        // 容器已经被加载了
        loaded = true;
    }
}
