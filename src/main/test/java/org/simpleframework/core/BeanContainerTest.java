package org.simpleframework.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.simpleFramework.core.BeanContainer;

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
    public void loadBeansTest(){
        Assertions.assertEquals(false,ioc.isLoaded());
        ioc.loadBeans("indi.xm.jy");
        Assertions.assertEquals(6,ioc.size());
        Assertions.assertEquals(true,ioc.isLoaded());

    }

}
