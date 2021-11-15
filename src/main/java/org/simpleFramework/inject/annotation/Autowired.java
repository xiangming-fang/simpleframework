package org.simpleFramework.inject.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: simpleframework
 * @Package: org.simpleFramework.inject.annotation
 * @ClassName: Autowired
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/15 17:38
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
    String value() default "";
}
