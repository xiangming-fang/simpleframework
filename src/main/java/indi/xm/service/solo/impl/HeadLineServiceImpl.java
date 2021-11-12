package indi.xm.service.solo.impl;

import indi.xm.entity.bo.HeadLine;
import indi.xm.entity.dto.Result;
import indi.xm.service.solo.HeadLineService;

import java.util.List;

/**
 * @ProjectName: simpleframework
 * @Package: indi.xm.service.solo.impl
 * @ClassName: HeadLineServiceImpl
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/8 18:29
 */
public class HeadLineServiceImpl implements HeadLineService {
    @Override
    public Result<Boolean> addHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<Boolean> removeHeadLine(int headLineId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<HeadLine> queryHeadLineById(int headLineId) {
        return null;
    }

    @Override
    public Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize) {
        return null;
    }
}
