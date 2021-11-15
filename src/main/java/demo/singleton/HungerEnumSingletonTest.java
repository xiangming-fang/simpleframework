package demo.singleton;

import java.lang.reflect.Constructor;

/**
 * @ProjectName: simpleframework
 * @Package: demo.singletom
 * @ClassName: SingletonTest
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/12 19:34
 */
public class HungerEnumSingletonTest {
    public static void main(String[] args) throws Exception {
        HungerEnumSingleton instance = HungerEnumSingleton.getInstance();
        System.out.println(instance);
        Class<HungerEnumSingleton> clazz = HungerEnumSingleton.class;
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        HungerEnumSingleton hungerEnumSingleton = (HungerEnumSingleton)declaredConstructor.newInstance();
        System.out.println(hungerEnumSingleton);


        System.out.println(HungerEnumSingleton.getInstance());

        Class clazz1 = HungerEnumSingleton.class;
        Constructor constructor=clazz1.getDeclaredConstructor();
        constructor.setAccessible(true);
        HungerEnumSingleton enumStarvingSingleton= (HungerEnumSingleton) constructor.newInstance();
        System.out.println(enumStarvingSingleton.getInstance());
        System.out.println(((HungerEnumSingleton) constructor.newInstance()).getInstance());
    }
}
