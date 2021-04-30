package com.imooc.entity.dto;

import com.imooc.entity.bo.HeadLine;
import com.imooc.entity.bo.ShopCategory;
import lombok.Data;

import java.util.List;

/**
 * <br>创建时间：2021/4/28
 *
 * @author 吴翔龙
 */
@Data
public class MainPageInfoDTO {

    private List<HeadLine> headLineList;

    private List<ShopCategory> shopCategoryList;

}
