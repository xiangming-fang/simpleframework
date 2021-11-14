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
}
