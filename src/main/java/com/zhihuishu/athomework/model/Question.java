package com.zhihuishu.athomework.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Question implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id; //试题id

    private Integer questionTypeId; //题型id

    private Integer diff; //难度 1 简单；2 中等；3难

    private String content; //习题的内容

    private String result; //答案

    private Integer from; //来源类别（1、自建，2导入，3其他题库共享）

    private Integer hit; //使用次数

    private Date createTime; //创建时间

    private Boolean isDisplay; //显示状态

    private Long userId; //创建人

    private Long parentId; //组合题大题编号

    private String analysis; //答案解析

    private Integer schoolId; //学校

    private Date updateTime; //修改时间

    private Long lastUpdateUserId; //最后修改人id

    private Boolean isDeleted; //删除状态

}