package indi.xm.jy.entity.dto;

import lombok.Data;

/**
 * @ProjectName: simpleframework
 * @Package: indi.xm.entity.dto
 * @ClassName: Result
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/8 18:20
 */
@Data
public class Result<T> {

    // 状态码 200 成功
    private int code;

    // 本次请求结果的详情
    private String msg;

    // 本次请求返回的结果集
    private T data;

}
