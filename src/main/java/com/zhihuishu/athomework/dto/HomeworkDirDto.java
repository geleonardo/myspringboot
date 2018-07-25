package com.zhihuishu.athomework.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class HomeworkDirDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer schoolId;

    private Long courseId;

    private Integer buildMode;

    private String title;

    private String content;

    private Date endTime;

    private Integer folderId;

    private Double Score;

    private String classIds;

    private Integer submitOption;

    private Integer isDelay;

    private Integer randMode;

    private Integer isPublish;

    private Integer showScore;

    private Long createUserId;

    private Date createTime;

    private Date updateTime;

    private List<HomeworkDirFileDto> fileList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Integer getBuildMode() {
        return buildMode;
    }

    public void setBuildMode(Integer buildMode) {
        this.buildMode = buildMode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public Double getScore() {
        return Score;
    }

    public void setScore(Double score) {
        Score = score;
    }

    public String getClassIds() {
        return classIds;
    }

    public void setClassIds(String classIds) {
        this.classIds = classIds;
    }

    public Integer getSubmitOption() {
        return submitOption;
    }

    public void setSubmitOption(Integer submitOption) {
        this.submitOption = submitOption;
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

    public List<HomeworkDirFileDto> getFileList() {
        return fileList;
    }

    public void setFileList(List<HomeworkDirFileDto> fileList) {
        this.fileList = fileList;
    }

    @Override
    public String toString() {
        return "HomeworkDirDto{" +
                "id=" + id +
                ", schoolId=" + schoolId +
                ", courseId=" + courseId +
                ", buildMode=" + buildMode +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", endTime=" + endTime +
                ", folderId=" + folderId +
                ", Score=" + Score +
                ", classIds='" + classIds + '\'' +
                ", submitOption=" + submitOption +
                ", isDelay=" + isDelay +
                ", randMode=" + randMode +
                ", isPublish=" + isPublish +
                ", showScore=" + showScore +
                ", createUserId=" + createUserId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
