package org.simpleframework.core;

import indi.xm.jy.controller.frontend.MainPageController;
import indi.xm.jy.entity.dto.Result;
import indi.xm.jy.service.combine.HeadLineShopCategoryCombineService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.simpleFramework.core.BeanContainer;
import org.simpleFramework.core.annotation.Controller;

import java.beans.beancontext.BeanContext;

/**
 * @ProjectName: simpleframework
 * @Package: org.simpleframework.core
 * @ClassName: BeanContainerTest
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/14 14:51
 */
public class BeanContainerTest {
    private static BeanContainer ioc;

    @BeforeAll
    static void init(){
        ioc = BeanContainer.getInstance();
    }


    @Test
    public void getBeanTest(){
        ioc.loadBeans("indi");
        MainPageController bean = ioc.getBean(MainPageController.class);
        System.out.println(bean.getHeadLineShopCategoryCombineService());
    }

    @Test
    public void loadBeansTest(){
        Assertions.assertEquals(false,ioc.isLoaded());
        ioc.loadBeans("indi");
        Assertions.assertEquals(6,ioc.size());
        Assertions.assertEquals(true,ioc.isLoaded());
    }

    @Test
    public void getClassByAnnotationTest(){
        ioc.loadBeans("indi");
        System.out.println(ioc.getClassByAnnotation(Controller.class));
    }

    @Test
    public void getClassBySuperTest(){
        ioc.loadBeans("indi");
        System.out.println(ioc.getClassBySuper(HeadLineShopCategoryCombineService.class));
    }

    @Test
    public void isAssignableFromTest(){
        // 判断  父 ——》 子
        if (Object.class.isAssignableFrom(Result.class)){
            System.out.println("判断  父 ——》 子");
        }

        // 判断  父 ——》 子
        if (Object.class.isAssignableFrom(Object.class)){
            System.out.println("判断  父 ——》 子");
        }
    }

}
