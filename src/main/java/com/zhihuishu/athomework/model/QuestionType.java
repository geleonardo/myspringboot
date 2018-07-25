package com.zhihuishu.athomework.model;

import java.io.Serializable;
import java.util.Date;

public class QuestionType implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id; //题型id

    private String title; //题型名称

    private String titleEn;

    private Date createTime;

    private Boolean isDeleted; //删除状态

    private String creater; //添加人

    private Integer sort; //显示顺序

    private String code;

    private Integer type; //类型(1添加类型2其他类型，主要用于区分注释说明和基础添加类型)

    private String inputText;
}
