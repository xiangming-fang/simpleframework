package indi.xm.service.combine;

import indi.xm.entity.dto.MainPageInfoDTO;
import indi.xm.entity.dto.Result;

/**
 * @ProjectName: simpleframework
 * @Package: indi.xm.service.combine
 * @ClassName: HeadLineShopCategoryCombineService
 * @Author: albert.fang
 * @Description:
 * @Date: 2021/11/8 18:30
 */
public interface HeadLineShopCategoryCombineService {

    Result<MainPageInfoDTO> getMainPageInfo();
}
