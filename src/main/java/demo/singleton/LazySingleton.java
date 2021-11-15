package demo.singleton;

import java.io.Serializable;

/**
 * @ProjectName: simpleframework
 * @Package: demo.singletom
 * @ClassName: LazySingleton
 * @Author: albert.fang
 * @Description: 懒汉模式
 * @Date: 2021/11/15 11:07
 */
public class LazySingleton implements Serializable {

    private static LazySingleton lazySingleton;

    private volatile static LazySingleton volatile_lazySingleton;

    private LazySingleton(){
    }

    // 并发不安全
    public static LazySingleton getInstance(){
        if (lazySingleton == null){
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    // 1、直接使用 synchronized
    public synchronized static LazySingleton getInstance01(){
        if (lazySingleton == null){
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    // 2、直接使用 synchronized 锁的粒度太大了，采用双重检查,非 volatile修饰单例对象
    public static LazySingleton getInstance02(){
        if (lazySingleton == null){
            synchronized (LazySingleton.class){
                if (lazySingleton == null){
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    // 4、volatile关键字，防止jvm对指令进行重排序，用 volatile修饰单例对象
    public static LazySingleton getInstance03(){
        if (volatile_lazySingleton == null){
//            try {
//                Thread.sleep(1L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            synchronized (LazySingleton.class){
//                if (volatile_lazySingleton == null){
                    volatile_lazySingleton = new LazySingleton();
//                }
//            }
        }
        return volatile_lazySingleton;
    }
}
