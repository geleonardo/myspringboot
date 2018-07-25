package com.zhihuishu.athomework.dto;

import java.io.Serializable;
import java.sql.Date;


public class HomeworkUserDto implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Long id;

    private Long homeworkId;

    private Long userId;

    private Long paperId;

    private Integer status;

    private Integer  isDelay;

    private Double subjectiveScore;

    private Double objectiveScore;

    private  Double deduct;

    private Date submitTime;

    private Integer similar;

    private String  remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelay() {
        return isDelay;
    }

    public void setIsDelay(Integer isDelay) {
        this.isDelay = isDelay;
    }

    public Double getSubjectiveScore() {
        return subjectiveScore;
    }

    public void setSubjectiveScore(Double subjectiveScore) {
        this.subjectiveScore = subjectiveScore;
    }

    public Double getObjectiveScore() {
        return objectiveScore;
    }

    public void setObjectiveScore(Double objectiveScore) {
        this.objectiveScore = objectiveScore;
    }

    public Double getDeduct() {
        return deduct;
    }

    public void setDeduct(Double deduct) {
        this.deduct = deduct;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Integer getSimilar() {
        return similar;
    }

    public void setSimilar(Integer similar) {
        this.similar = similar;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "HomeworkUserDto{" +
                "id=" + id +
                ", homeworkId=" + homeworkId +
                ", userId=" + userId +
                ", paperId=" + paperId +
                ", status=" + status +
                ", isDelay=" + isDelay +
                ", subjectiveScore=" + subjectiveScore +
                ", objectiveScore=" + objectiveScore +
                ", deduct=" + deduct +
                ", submitTime=" + submitTime +
                ", similar=" + similar +
                ", remark='" + remark + '\'' +
                '}';
    }




}
