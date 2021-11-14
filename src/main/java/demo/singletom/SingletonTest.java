package demo.singletom;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ProjectName: simpleframework
 * @Package: demo.singletom
 * @ClassName: SingletonTest
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/12 19:34
 */
public class SingletonTest {
    public static void main(String[] args) throws Exception {
        HungerEnumSingleton instance = HungerEnumSingleton.getInstance();
        HungerEnumSingleton instance1 = HungerEnumSingleton.getInstance();
        System.out.println(instance);
        System.out.println(instance1);
        Class<HungerEnumSingleton> clazz = HungerEnumSingleton.class;
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        HungerEnumSingleton hungerEnumSingleton = (HungerEnumSingleton)declaredConstructor.newInstance();
        System.out.println(hungerEnumSingleton);
        System.out.println(hungerEnumSingleton == instance);
    }
}
