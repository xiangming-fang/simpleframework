package demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: simpleframework
 * @Package: demo.annotation
 * @ClassName: CourseInfoAnnotation
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/9 13:45
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseInfoAnnotation {

    // 课程名称
    public String courseName();
    // 课程标签
    public String courseTag();
    // 课程简介
    public String courseProfile();
    // 课程id
    public long courseId() default 303L;
}
