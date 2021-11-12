package indi.xm.service.solo;

import indi.xm.entity.bo.HeadLine;
import indi.xm.entity.dto.Result;

import java.util.List;

/**
 * @ProjectName: simpleframework
 * @Package: indi.xm.service.solo
 * @ClassName: HeadLineService
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/8 18:23
 */
public interface HeadLineService {

    Result<Boolean> addHeadLine(HeadLine headLine);

    Result<Boolean> removeHeadLine(int headLineId);

    Result<Boolean> modifyHeadLine(HeadLine headLine);

    Result<HeadLine> queryHeadLineById(int headLineId);

    Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition,
                                         int pageIndex,
                                         int pageSize);
}
