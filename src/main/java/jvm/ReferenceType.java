package jvm;

import java.lang.ref.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: simpleframework
 * @Package: jvm
 * @ClassName: SoftReference
 * @Author: albert.fang
 * @Description: 应用类型
 * @Date: 2021/12/14 14:03
 */
public class ReferenceType {

    private static ReferenceQueue<User> fq = new ReferenceQueue<User>();

    // 软引用
    private static void testSoftReference() throws InterruptedException {
        ArrayList<SoftReference<User>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            SoftReference<User> sr = new SoftReference<>(new User("soft " + i),fq);

//            System.out.println("now the soft user === " + sr.get());

            list.add(sr);

        }

        System.gc();

        TimeUnit.SECONDS.sleep(1);
    }

    // 弱引用
    private static void testWeakReference() throws InterruptedException {
        ArrayList<WeakReference<User>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            WeakReference<User> sr = new WeakReference<>(new User("week " + i),fq);

//            System.out.println("now the soft user === " + sr.get());

            list.add(sr);

        }

        System.gc();

        TimeUnit.SECONDS.sleep(1);
    }

    // 虚引用
    private static void testPhantomReference() throws InterruptedException {
        ArrayList<PhantomReference<User>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            PhantomReference<User> sr = new PhantomReference<>(new User("week " + i),fq);

//            System.out.println("now the soft user === " + sr.get());

            list.add(sr);

        }

        System.gc();

        TimeUnit.SECONDS.sleep(1);
    }


    private static void printQueue(String str) {
        Reference<? extends User> obj = fq.poll();
        if (obj != null){
            System.out.println("the gc object reference == " + str + " = " + obj.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {

//        testSoftReference();

        testWeakReference();

//        testPhantomReference();

        printQueue("soft Reference");
    }

}
