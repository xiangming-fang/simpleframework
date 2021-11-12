package demo.reflect;

/**
 * @ProjectName: simpleframework
 * @Package: demo.reflect
 * @ClassName: ReflectTarget
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/9 12:49
 */
public class ReflectTarget {
    public static void main(String[] args) throws ClassNotFoundException {
        // 第一种获取Class对象
        ReflectTarget reflectTarget = new ReflectTarget();
        Class<? extends ReflectTarget> aClass1 = reflectTarget.getClass();

        // 第二种获取Class对象
        Class<ReflectTarget> aClass2 = ReflectTarget.class;

        // 第三种获取Class对象，最常用
        Class<?> aClass3 = Class.forName("demo.reflect.ReflectTarget");

        System.out.println(aClass1 == aClass2);
        System.out.println(aClass2 == aClass3);
        System.out.println(aClass1 == aClass3);

    }
}
