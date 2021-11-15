package org.simpleframework.inject;

import indi.xm.jy.controller.frontend.MainPageController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.simpleFramework.core.BeanContainer;
import org.simpleFramework.inject.annotation.DependencyInjector;

/**
 * @ProjectName: simpleframework
 * @Package: org.simpleframework.inject
 * @ClassName: DependencyInjectorTest
 * @Author: albert.fang
 * @Description: 依赖注入测试
 * @Date: 2021/11/15 18:08
 */
public class DependencyInjectorTest {

    private static BeanContainer ioc;

    @BeforeAll
    static void init(){
        ioc = BeanContainer.getInstance();
    }

    @Test
    public void doIocTest(){
        ioc.loadBeans("indi");
        MainPageController mainPageController = ioc.getBean(MainPageController.class);
        if (mainPageController instanceof MainPageController) {
            // 应该是null
            Assertions.assertNull(mainPageController.getHeadLineShopCategoryCombineService());
            System.out.println(mainPageController.getHeadLineShopCategoryCombineService());
        }

        // 实现依赖注入
        new DependencyInjector().doIoc();

        // 应该是null
        Assertions.assertNotNull(mainPageController.getHeadLineShopCategoryCombineService());
        System.out.println(mainPageController.getHeadLineShopCategoryCombineService());
    }
}
