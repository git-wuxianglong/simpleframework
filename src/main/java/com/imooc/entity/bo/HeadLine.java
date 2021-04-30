package com.imooc.entity.bo;

import lombok.Data;

import java.util.Date;

/**
 * <br>创建时间：2021/4/28
 *
 * @author 吴翔龙
 */
@Data
public class HeadLine {
    private Long lineId;
    private String lineName;
    private String lineLink;
    private String lineImg;
    private Integer priority;
    private Integer enableStatus;
    private Date createTime;
    private Date lastEditTime;
}
