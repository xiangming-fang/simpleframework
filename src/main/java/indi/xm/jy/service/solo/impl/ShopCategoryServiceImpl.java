package indi.xm.jy.service.solo.impl;

import indi.xm.jy.entity.bo.ShopCategory;
import indi.xm.jy.entity.dto.Result;
import indi.xm.jy.service.solo.ShopCategoryService;
import org.simpleFramework.core.annotation.Service;

import java.util.List;

/**
 * @ProjectName: simpleframework
 * @Package: indi.xm.service.solo.impl
 * @ClassName: ShopCategoryServiceImpl
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/8 18:28
 */
@Service
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
