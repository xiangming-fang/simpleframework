package demo.singletom;

/**
 * @ProjectName: simpleframework
 * @Package: demo.singletom
 * @ClassName: HungerSingleton
 * @Author: albert.fang
 * @Description: 饿汉模式 + 枚举
 * @Date: 2021/11/12 19:30
 */
public class HungerEnumSingleton {

    private HungerEnumSingleton(){}

    public static HungerEnumSingleton getInstance(){
        return HungerEnum.HES.hungerEnumSingleton;
    }

    private enum HungerEnum{

        HES;

        private HungerEnumSingleton hungerEnumSingleton;

        HungerEnum(){
            hungerEnumSingleton = new HungerEnumSingleton();
        }
    }
}
