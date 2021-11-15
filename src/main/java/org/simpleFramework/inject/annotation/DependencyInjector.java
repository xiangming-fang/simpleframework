package org.simpleFramework.inject.annotation;

import lombok.extern.slf4j.Slf4j;
import org.simpleFramework.core.BeanContainer;
import org.simpleFramework.util.ClassUtil;
import org.simpleFramework.util.ValidationUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * @ProjectName: simpleframework
 * @Package: org.simpleFramework.inject.annotation
 * @ClassName: DependencyInjector
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/15 17:40
 */
@Slf4j
public class DependencyInjector {

    /**
     * bean容器
     */
    private BeanContainer ioc;

    public DependencyInjector(){
        ioc = BeanContainer.getInstance();
        ioc.loadBeans("indi");
    }

    /**
     * 执行ioc
     */
    public void doIoc(){
        // 1、遍历bean容器中所有的class对象
        Set<Class<?>> classes = ioc.getClasses();
        if (ValidationUtil.isEmpty(classes)){
            log.warn("no class in ioc");
            return;
        }
        // 2、遍历class对象的所有成员变量
        for (Class<?> aClass : classes) {
            for (Field declaredField : aClass.getDeclaredFields()) {
                // 3、找出被Autowired标记的成员变量
                if (declaredField.isAnnotationPresent(Autowired.class)) {
                    Autowired annotation = declaredField.getAnnotation(Autowired.class);
                    // 4、获取这些成员变量的类型
                    Class<?> type = declaredField.getType();
                    // 5、获取这些成员变量的类型在容器里对应的实例
                    Object filedValue = getFieldInstance(type,annotation.value());
                    if (filedValue == null){
                        throw new RuntimeException("inject filed");
                    }else {
                        // 6、通过反射将对应的成员变量注入到成员变量所在类的实例里
                        Object targetBean = ioc.getBean(aClass);
                        ClassUtil.setFiled(declaredField,targetBean,filedValue,true);
                    }
                }
            }
        }
    }

    private Object getFieldInstance(Class<?> type,String injectValue) {
        // 注入的方式不是抽象类或者接口，只有一个
        Object bean = ioc.getBean(type);
        if (bean != null){
            return bean;
        }
        // 以接口方式的话
        Set<Class<?>> classBySuper = ioc.getClassBySuper(type);
        if (ValidationUtil.isEmpty(classBySuper)){
            log.warn("不存在这个接口");
            return null;
        }
        if (ValidationUtil.isEmpty(injectValue)){
            if (classBySuper.size() == 1){
                return ioc.getBean(classBySuper.iterator().next());
            }
            else {
                throw new RuntimeException("具体实现哪个哦，请指明类型哦");
            }
        }else {
            for (Class<?> aClass : classBySuper) {
                if (injectValue.equalsIgnoreCase(aClass.getSimpleName())) {
                    return ioc.getBean(aClass);
                }
            }
        }
        return null;
    }
}
