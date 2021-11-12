package demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: simpleframework
 * @Package: demo.annotation
 * @ClassName: PersonInfoAnnotation
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/9 13:41
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonInfoAnnotation {
    // 名字
    public String name();
    // 年龄
    public int age() default 19;
    // 性别
    public String gender() default "男";
    // 开发语言
    public String[] language();
}
