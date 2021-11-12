package demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ProjectName: simpleframework
 * @Package: demo.annotation
 * @ClassName: AnnotationParser
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/9 13:57
 */
public class AnnotationParser {

    // 解析类上的注解
    public static void parseTypeAnnotation() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("demo.annotation.ImoocCourse");
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            CourseInfoAnnotation courseInfoAnnotation = (CourseInfoAnnotation)annotation;
            System.out.println("课程名" + courseInfoAnnotation.courseName());
            System.out.println("课程标签" + courseInfoAnnotation.courseTag());
            System.out.println("课程简介" + courseInfoAnnotation.courseProfile());
            System.out.println("课程id " + courseInfoAnnotation.courseId());
        }
    }

    // 解析属性上的注解
    public static void parseFiledAnnotation() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("demo.annotation.ImoocCourse");
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(PersonInfoAnnotation.class)) {
                PersonInfoAnnotation personInfoAnnotation = field.getAnnotation(PersonInfoAnnotation.class);
                System.out.println(personInfoAnnotation.name());
                System.out.println(personInfoAnnotation.age());
                System.out.println(personInfoAnnotation.gender());
                System.out.println(Arrays.toString(personInfoAnnotation.language()));
            }
        }
    }

    // 解析方法上的注解
    public static void parseMethodAnnotation() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("demo.annotation.ImoocCourse");
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(CourseInfoAnnotation.class)) {
                CourseInfoAnnotation courseInfoAnnotation = method.getAnnotation(CourseInfoAnnotation.class);
                System.out.println("课程名" + courseInfoAnnotation.courseName());
                System.out.println("课程标签" + courseInfoAnnotation.courseTag());
                System.out.println("课程简介" + courseInfoAnnotation.courseProfile());
                System.out.println("课程id " + courseInfoAnnotation.courseId());
            }
        }
    }


    public static void main(String[] args) throws ClassNotFoundException {
//        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
//        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
//        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
//        parseTypeAnnotation();
        parseFiledAnnotation();
//        parseMethodAnnotation();
    }
}
