package demo.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: simpleframework
 * @Package: demo.singletom
 * @ClassName: LazySingletonTest
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/15 11:13
 */
public class LazySingletonTest {

    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        currentAttack();
//        reflectAttack();
//        serializeAttack();
    }

    // 1、并发攻击
    private static void currentAttack(){
        List<Thread> currentAttacks = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            currentAttacks.add(new Thread(new CurrentAttack(),"第 " + i + "个线程"));
        }
        currentAttacks.forEach(Thread::start);
    }

    // 2、反射攻击
    private static void reflectAttack() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        LazySingleton instance = LazySingleton.getInstance();
        System.out.println(instance);

        Class<LazySingleton> lazySingletonClass = LazySingleton.class;
        Constructor<LazySingleton> declaredConstructor = lazySingletonClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        LazySingleton lazySingleton = declaredConstructor.newInstance();
        System.out.println(lazySingleton);
        if (lazySingleton != instance){
            System.err.println("反射攻击单例对象成功");
        }
    }

    // 3、序列化、反序列化攻击
    private static void serializeAttack() throws IOException {
        LazySingleton instance = LazySingleton.getInstance();
        System.out.println(instance);
        // a、序列化到磁盘文件
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.txt"))) {
            objectOutputStream.writeObject(LazySingleton.getInstance());
        }
        // b、反序列化到内存
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.txt"))) {
            final LazySingleton lazySingleton = (LazySingleton)objectInputStream.readObject();
            System.out.println(lazySingleton);
            if (lazySingleton != instance){
                System.err.println("序列化、反序列化攻击成功");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class CurrentAttack implements Runnable{

        @Override
        public void run() {
            System.out.println(LazySingleton.getInstance02());
//            System.out.println(LazySingleton.getInstance());
        }
    }
}
