package indi.xm.service.combine;

import indi.xm.entity.bo.HeadLine;
import indi.xm.entity.bo.ShopCategory;
import indi.xm.entity.dto.MainPageInfoDTO;
import indi.xm.entity.dto.Result;
import indi.xm.service.solo.HeadLineService;
import indi.xm.service.solo.ShopCategoryService;

import java.util.List;

/**
 * @ProjectName: simpleframework
 * @Package: indi.xm.service.combine
 * @ClassName: HeadLineShopCategoryCombineServiceImpl
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/8 18:32
 */
public class HeadLineShopCategoryCombineServiceImpl implements HeadLineShopCategoryCombineService{

    private HeadLineService headLineService;

    private ShopCategoryService shopCategoryService;

    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {

        // 1、获取头条列表
        HeadLine headLineCondition = new HeadLine();
        headLineCondition.setEnableStatus(1);
        Result<List<HeadLine>> headLineResult = headLineService.queryHeadLine(headLineCondition, 1, 4);

        // 2、获取店铺类别列表
        ShopCategory shopCategoryCondition = new ShopCategory();
        Result<List<ShopCategory>> queryShopCategoryResult = shopCategoryService.queryShopCategory(shopCategoryCondition, 1, 10);

        // 3、合并两者返回
        MainPageInfoDTO mainPageInfoDTO = new MainPageInfoDTO();
        mainPageInfoDTO.setHeadLineList(headLineResult.getData());
        mainPageInfoDTO.setShopCategoryList(queryShopCategoryResult.getData());

        Result<MainPageInfoDTO> mainPageInfoDTOResult = new Result<>();
        mainPageInfoDTOResult.setData(mainPageInfoDTO);
        return mainPageInfoDTOResult;
    }
}
