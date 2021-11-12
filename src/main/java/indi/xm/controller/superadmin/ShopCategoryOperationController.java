package indi.xm.controller.superadmin;

import indi.xm.entity.bo.ShopCategory;
import indi.xm.entity.dto.Result;
import indi.xm.service.solo.ShopCategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ProjectName: simpleframework
 * @Package: indi.xm.controller.superadmin
 * @ClassName: ShopCategoryOperationController
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/8 19:13
 */
public class ShopCategoryOperationController {

    private ShopCategoryService ShopCategoryService;

    public Result<Boolean> addShopCategory(HttpServletRequest req, HttpServletResponse reqs){
        return ShopCategoryService.addShopCategory(null);
    }

    public Result<Boolean> removeShopCategory(HttpServletRequest req, HttpServletResponse reqs){
        return ShopCategoryService.removeShopCategory(0);
    }

    public Result<Boolean> modifyShopCategory(HttpServletRequest req, HttpServletResponse reqs){
        return ShopCategoryService.modifyShopCategory(null);
    }

    public Result<ShopCategory> queryShopCategoryById(HttpServletRequest req, HttpServletResponse reqs){
        return ShopCategoryService.queryShopCategoryById(0);
    }

    public Result<List<ShopCategory>> queryShopCategory(HttpServletRequest req, HttpServletResponse reqs){
        return ShopCategoryService.queryShopCategory(null,1,1);
    }
}
