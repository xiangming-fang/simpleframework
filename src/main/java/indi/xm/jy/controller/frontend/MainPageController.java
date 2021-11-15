package indi.xm.jy.controller.frontend;

import indi.xm.jy.entity.dto.MainPageInfoDTO;
import indi.xm.jy.entity.dto.Result;
import indi.xm.jy.service.combine.HeadLineShopCategoryCombineService;
import lombok.Getter;
import org.simpleFramework.core.annotation.Controller;
import org.simpleFramework.inject.annotation.Autowired;

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
@Controller
@Getter
public class MainPageController {

    @Autowired
    private HeadLineShopCategoryCombineService headLineShopCategoryCombineService;

    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest req, HttpServletResponse reqs){
        return headLineShopCategoryCombineService.getMainPageInfo();
    }
}
