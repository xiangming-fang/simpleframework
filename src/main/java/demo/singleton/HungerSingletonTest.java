package demo.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: simpleframework
 * @Package: demo.singleton
 * @ClassName: HungerSingletonTest
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/15 13:27
 */
public class HungerSingletonTest {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IOException {
//        currentAttack();
        reflectAttack();
        serializeAttack();
    }

    // 1、并发攻击
    private static void currentAttack(){
        List<Thread> currentAttacks = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            currentAttacks.add(new Thread(new CurrentAttack(),"第 " + i + "个线程"));
        }
        currentAttacks.forEach(Thread::start);
    }

    // 2、反射攻击
    private static void reflectAttack() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        HungerSingleton instance = HungerSingleton.getInstance();
        System.out.println(instance);

        Class<HungerSingleton> hungerSingletonClass = HungerSingleton.class;
        Constructor<HungerSingleton> declaredConstructor = hungerSingletonClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        HungerSingleton hungerSingleton = declaredConstructor.newInstance();
        System.out.println(hungerSingleton);
        if (hungerSingleton != instance){
            System.err.println("反射攻击单例对象成功");
        }
    }

    // 3、序列化、反序列化攻击
    private static void serializeAttack() throws IOException {
        HungerSingleton instance = HungerSingleton.getInstance();
        System.out.println(instance);
        // a、序列化到磁盘文件
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.txt"))) {
            objectOutputStream.writeObject(HungerSingleton.getInstance());
        }
        // b、反序列化到内存
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.txt"))) {
            final HungerSingleton hungerSingleton = (HungerSingleton)objectInputStream.readObject();
            System.out.println(hungerSingleton);
            if (hungerSingleton != instance){
                System.err.println("序列化、反序列化攻击成功");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class CurrentAttack implements Runnable{

        @Override
        public void run() {
            System.out.println(HungerSingleton.getInstance());
        }
    }
}
