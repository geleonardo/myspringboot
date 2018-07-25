package com.zhihuishu.athomework.model.homework;

import java.io.Serializable;
import java.util.Date;

public class Homework  implements Serializable{

    private static final Long serialVersionUID = 1L;

    private Long id;

    private Long courseId;

    private String title;

    private Date endTime;

    private  Integer buildMode;

    private Long folderId;

    private Integer submitOption;

    private  Integer isPublish;

    private  Integer isDelay;

    private Integer randMode;

    private Long createUserId;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getBuildMode() {
        return buildMode;
    }

    public void setBuildMode(Integer buildMode) {
        this.buildMode = buildMode;
    }

    public Long getFolderId() {
        return folderId;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }

    public Integer getSubmitOption() {
        return submitOption;
    }

    public void setSubmitOption(Integer submitOption) {
        this.submitOption = submitOption;
    }

    public Integer getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    public Integer getIsDelay() {
        return isDelay;
    }

    public void setIsDelay(Integer isDelay) {
        this.isDelay = isDelay;
    }

    public Integer getRandMode() {
        return randMode;
    }

    public void setRandMode(Integer randMode) {
        this.randMode = randMode;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", title='" + title + '\'' +
                ", endTime=" + endTime +
                ", buildMode=" + buildMode +
                ", folderId=" + folderId +
                ", submitOption=" + submitOption +
                ", isPublish=" + isPublish +
                ", isDelay=" + isDelay +
                ", randMode=" + randMode +
                ", createUserId=" + createUserId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
