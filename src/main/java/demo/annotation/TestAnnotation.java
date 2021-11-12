package demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: simpleframework
 * @Package: demo.annotation
 * @ClassName: TestAnnotation
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/9 13:16
 */
@Target(value = {ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface TestAnnotation {

}
