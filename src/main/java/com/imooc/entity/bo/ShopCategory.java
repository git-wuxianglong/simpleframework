package com.imooc.entity.bo;

import lombok.Data;

import java.util.Date;

/**
 * <br>创建时间：2021/4/28
 *
 * @author 吴翔龙
 */
@Data
public class ShopCategory {
    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private ShopCategory parent;
}
