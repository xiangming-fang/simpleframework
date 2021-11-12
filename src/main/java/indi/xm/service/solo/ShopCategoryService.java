package indi.xm.service.solo;

import indi.xm.entity.bo.ShopCategory;
import indi.xm.entity.dto.Result;

import java.util.List;

/**
 * @ProjectName: simpleframework
 * @Package: indi.xm.service.solo
 * @ClassName: ShopCategoryService
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/8 18:24
 */
public interface ShopCategoryService {
    Result<Boolean> addShopCategory(ShopCategory shopCategory);

    Result<Boolean> removeShopCategory(int shopCategoryId);

    Result<Boolean> modifyShopCategory(ShopCategory shopCategory);

    Result<ShopCategory> queryShopCategoryById(int shopCategoryId);

    Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryContion,
                                         int pageIndex,
                                         int pageSize);
}
