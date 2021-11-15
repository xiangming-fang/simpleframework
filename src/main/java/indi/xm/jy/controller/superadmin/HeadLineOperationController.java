package indi.xm.jy.controller.superadmin;

import indi.xm.jy.entity.bo.HeadLine;
import indi.xm.jy.entity.dto.Result;
import indi.xm.jy.service.solo.HeadLineService;
import org.simpleFramework.core.annotation.Controller;
import org.simpleFramework.inject.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ProjectName: simpleframework
 * @Package: indi.xm.controller.superadmin
 * @ClassName: HeadLineOperationController
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/8 19:10
 */
@Controller
public class HeadLineOperationController {

    @Autowired
    private HeadLineService headLineService;

    public Result<Boolean> addHeadLine(HttpServletRequest req, HttpServletResponse reqs){
        return headLineService.addHeadLine(null);
    }

    public Result<Boolean> removeHeadLine(HttpServletRequest req, HttpServletResponse reqs){
        return headLineService.removeHeadLine(0);
    }

    public Result<Boolean> modifyHeadLine(HttpServletRequest req, HttpServletResponse reqs){
        return headLineService.modifyHeadLine(null);
    }

    public Result<HeadLine> queryHeadLineById(HttpServletRequest req, HttpServletResponse reqs){
        return headLineService.queryHeadLineById(0);
    }

    public Result<List<HeadLine>> queryHeadLine(HttpServletRequest req, HttpServletResponse reqs){
        return headLineService.queryHeadLine(null,1,1);
    }


}
