package indi.xm.jy.entity.bo;

import lombok.Data;

import java.util.Date;

/**
 * @ProjectName: simpleframework
 * @Package: indi.xm.entity.bo
 * @ClassName: ShopCategory
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/8 17:39 bo：业务逻辑实体对象
 */
@Data
public class ShopCategory {
    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private ShopCategory parent;
}
