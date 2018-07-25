package com.zhihuishu.athomework.dto;

import java.io.Serializable;
import java.sql.Date;

public class HomeworkDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long courseId;

    private String title;

    private Date endTime;

    private Integer buildMode;

    private Integer folderId;

    private Integer submitOption;

    private Integer isPublish;

    private Integer showScore;

    private Integer isDelay;

    private Integer randMode;

    private Long createUserId;

    private Date createTime;

    private Date updateTime;

    private Integer schoolId;

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

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
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

    public Integer getShowScore() {
        return showScore;
    }

    public void setShowScore(Integer showScore) {
        this.showScore = showScore;
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

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "HomeworkDto{" +
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
                ", schoolId=" + schoolId +
                '}';
    }

}
