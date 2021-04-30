package com.imooc.service.combine.impl;

import com.imooc.entity.bo.HeadLine;
import com.imooc.entity.bo.ShopCategory;
import com.imooc.entity.dto.MainPageInfoDTO;
import com.imooc.entity.dto.Result;
import com.imooc.service.combine.HeadLineServiceShopCategoryCombineService;
import com.imooc.service.solo.HeadLineService;
import com.imooc.service.solo.ShopCategoryService;

import java.util.List;

/**
 * <br>创建时间：2021/4/28
 *
 * @author 吴翔龙
 */
public class HeadLineServiceShopCategoryCombineServiceImpl implements HeadLineServiceShopCategoryCombineService {

    private HeadLineService headLineService;
    private ShopCategoryService shopCategoryService;

    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {
        HeadLine headLine = new HeadLine();
        headLine.setEnableStatus(1);
        Result<List<HeadLine>> headLineListResult = headLineService.queryHeadLine(headLine, 1, 4);

        ShopCategory shopCategory = new ShopCategory();
        Result<List<ShopCategory>> shopCategoryListResult = shopCategoryService.queryShopCategory(shopCategory, 1, 10);

        return mergeMainPageInfoResult(headLineListResult, shopCategoryListResult);

    }

    private Result<MainPageInfoDTO> mergeMainPageInfoResult(Result<List<HeadLine>> headLineListResult, Result<List<ShopCategory>> shopCategoryListResult) {
        return null;
    }
}
