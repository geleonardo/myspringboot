package com.zhihuishu.athomework.dto;

import java.io.Serializable;
import java.util.Date;

public class QuestionTypeDto implements Serializable{

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    @Override
    public String toString() {
        return "QuestionTypeDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", titleEn='" + titleEn + '\'' +
                ", createTime=" + createTime +
                ", isDeleted=" + isDeleted +
                ", creater='" + creater + '\'' +
                ", sort=" + sort +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", inputText='" + inputText + '\'' +
                '}';
    }
}
