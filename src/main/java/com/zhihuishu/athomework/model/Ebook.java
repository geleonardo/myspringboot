package com.zhihuishu.athomework.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Ebook implements Serializable {
    private static final long serialVersionUID = 1L;

    // 主键
    private Integer ebookId;
    // 电子书名称
    private String name;
    // 电子书作者
    private String author;
    // 电子书描述
    private String desc;
    // 电子书地址
    private Integer dataId;
    // 电子书收费类型
    private Integer chargeType;
    // 电子书封面
    private String coverPicture;
    // 电子书字数
    private Integer wordsNum;
    // 电子书版权
    private String copyright;
    // 是否能分享
    private Integer canShare;
    // 价格
    private Integer price;
    // 免费章节
    private Integer freeChapters;
    // 电子书类型
    private String ebookType;
    // 电子书大小
    private String ebookSize;

    public Integer getEbookId() {
        return ebookId;
    }

    public void setEbookId(Integer ebookId) {
        this.ebookId = ebookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
    }

    public Integer getWordsNum() {
        return wordsNum;
    }

    public void setWordsNum(Integer wordsNum) {
        this.wordsNum = wordsNum;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getCanShare() {
        return canShare;
    }

    public void setCanShare(Integer canShare) {
        this.canShare = canShare;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getFreeChapters() {
        return freeChapters;
    }

    public void setFreeChapters(Integer freeChapters) {
        this.freeChapters = freeChapters;
    }

    public String getEbookType() {
        return ebookType;
    }

    public void setEbookType(String ebookType) {
        this.ebookType = ebookType;
    }

    public String getEbookSize() {
        return ebookSize;
    }

    public void setEbookSize(String ebookSize) {
        this.ebookSize = ebookSize;
    }
}
