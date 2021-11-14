package indi.xm.jy.entity.bo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @ProjectName: simpleframework
 * @Package: indi.xm.entity.bo
 * @ClassName: HeadLine
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/8 17:39
 */
@Data
public class HeadLine {
    private Long lineId;
    private String lineName;
    private String lineLink;
    private String lineImg;
    private Integer priority;
    // 0-不可用 1- 可用
    private Integer enableStatus;
    private Date createTime;
    private Date lastEditTime;
}
