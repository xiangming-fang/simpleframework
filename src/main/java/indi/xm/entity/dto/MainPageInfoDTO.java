package indi.xm.entity.dto;

import indi.xm.entity.bo.HeadLine;
import indi.xm.entity.bo.ShopCategory;
import lombok.Data;

import java.util.List;

/**
 * @ProjectName: simpleframework
 * @Package: indi.xm.entity.dto
 * @ClassName: MainPageInfoDTO
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/8 18:31
 */
@Data
public class MainPageInfoDTO {
    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;
}
