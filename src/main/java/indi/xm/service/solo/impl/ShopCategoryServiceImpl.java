package indi.xm.service.solo.impl;

import indi.xm.entity.bo.ShopCategory;
import indi.xm.entity.dto.Result;
import indi.xm.service.solo.ShopCategoryService;

import java.util.List;

/**
 * @ProjectName: simpleframework
 * @Package: indi.xm.service.solo.impl
 * @ClassName: ShopCategoryServiceImpl
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/8 18:28
 */
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Override
    public Result<Boolean> addShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<Boolean> removeShopCategory(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<ShopCategory> queryShopCategoryById(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryContion, int pageIndex, int pageSize) {
        return null;
    }
}
