package indi.xm.controller.frontend;

import indi.xm.entity.dto.MainPageInfoDTO;
import indi.xm.entity.dto.Result;
import indi.xm.service.combine.HeadLineShopCategoryCombineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: simpleframework
 * @Package: indi.xm.controller.frontend
 * @ClassName: MainPageController
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/8 19:08
 */
public class MainPageController {
    public HeadLineShopCategoryCombineService headLineShopCategoryCombineService;
    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest req, HttpServletResponse reqs){
        return headLineShopCategoryCombineService.getMainPageInfo();
    }
}
