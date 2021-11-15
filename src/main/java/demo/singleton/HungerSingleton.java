package demo.singleton;

import java.io.Serializable;

/**
 * @ProjectName: simpleframework
 * @Package: demo.singleton
 * @ClassName: HungerSingleton
 * @Author: albert.fang
 * @Description: 饿汉模式
 * @Date: 2021/11/15 13:23
 */
public class HungerSingleton implements Serializable {

    private static final HungerSingleton hungerSingleton = new HungerSingleton();

    private HungerSingleton() {}

    public static HungerSingleton getInstance(){
        try {
            Thread.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hungerSingleton;
    }
}
