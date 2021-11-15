package org.simpleFramework.util;

import java.util.Collection;

/**
 * @ProjectName: simpleframework
 * @Package: org.simpleFramework.util
 * @ClassName: ValidationUtil
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/14 14:46
 */
public class ValidationUtil {

    public static boolean isEmpty(Collection<?> collection){
        return collection == null || collection.isEmpty();
    }

    /**
     * String是否为null或""
     *
     * @param obj String
     * @return 是否为空
     */
    public static boolean isEmpty(String obj) {
        return (obj == null || "".equals(obj));
    }

    /**
     * Array是否为null或者size为0
     *
     * @param obj Array
     * @return 是否为空
     */
    public static boolean isEmpty(Object[] obj) {
        return obj == null || obj.length == 0;
    }
}
