package com.zhihuishu.athomework.model;

import java.io.Serializable;
import java.sql.Date;

public class Paper implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private Long userId;

    private Long courseId;

    private Date createTime;

    private Integer paperType;

    private Integer schoolId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPaperType() {
        return paperType;
    }

    public void setPaperType(Integer paperType) {
        this.paperType = paperType;
    }

    public Integer getschoolId() {
        return schoolId;
    }

    public void setschoolId(Integer schoolID) {
        schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", createTime=" + createTime +
                ", paperType=" + paperType +
                ", schoolId=" + schoolId +
                '}';
    }
}
