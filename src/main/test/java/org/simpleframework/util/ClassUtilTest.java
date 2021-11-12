package org.simpleframework.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.simpleFramework.util.ClassUtil;

import java.util.Set;

/**
 * @ProjectName: simpleframework
 * @Package: org.simpleframework.util
 * @ClassName: ClassUtilTest
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/11 19:43
 */
public class ClassUtilTest {

    @Test
    public void extractPackageClassTest(){
        Set<Class<?>> classSet = ClassUtil.extractPackageClass("indi.xm.entity");
        System.out.println(classSet);
        assert classSet != null;
        Assertions.assertEquals(4,classSet.size());
    }
}
