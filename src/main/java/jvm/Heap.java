package jvm;

import java.util.ArrayList;

/**
 * @ProjectName: simpleframework
 * @Package: jvm
 * @ClassName: Heap
 * @Author: albert.fang
 * @Description: 堆内存
 * @Date: 2021/12/13 17:58
 */
public class Heap {
    public static final String s = "sdfasf";
    public static void main(String[] args) {
//        xmsAndXmx();
        ArrayList<byte[]> bytes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            bytes.add(new byte[1024 * 1024]);
            System.out.println(i);
        }
    }

    public static void xmsAndXmx() {
        System.out.println("totalMemory === " + Runtime.getRuntime().totalMemory()/1024.0/1024.0);
        System.out.println("freeMemory === " + Runtime.getRuntime().freeMemory()/1024.0/1024.0);
        System.out.println("maxMemory === " + Runtime.getRuntime().maxMemory()/1024.0/1024.0);
    }
}
