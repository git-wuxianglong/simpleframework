package com.imooc.entity.dto;

import lombok.Data;

/**
 * <br>创建时间：2021/4/28
 *
 * @author 吴翔龙
 */
@Data
public class Result<T> {

    private int code;

    private String msg;

    private T data;

}
