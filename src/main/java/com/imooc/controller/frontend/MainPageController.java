package com.imooc.controller.frontend;

import com.imooc.entity.dto.MainPageInfoDTO;
import com.imooc.entity.dto.Result;
import com.imooc.service.combine.HeadLineServiceShopCategoryCombineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <br>创建时间：2021/4/28
 *
 * @author 吴翔龙
 */
public class MainPageController {

    private HeadLineServiceShopCategoryCombineService headLineServiceShopCategoryCombineService;

    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest req, HttpServletResponse resp) {
        return headLineServiceShopCategoryCombineService.getMainPageInfo();
    }

}
