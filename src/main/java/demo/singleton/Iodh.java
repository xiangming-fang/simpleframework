package demo.singleton;

import java.io.Serializable;

/**
 * @ProjectName: simpleframework
 * @Package: demo.singleton
 * @ClassName: Iodh
 * @Author: albert.fang
 * @Description: 静态内部类
 * @Date: 2021/11/15 13:34
 */
public class Iodh implements Serializable {

    private Iodh(){}

    static class InnerClass{
        private static final Iodh instance = new Iodh();
    }

    public static Iodh getInstance(){
        return InnerClass.instance;
    }
}
