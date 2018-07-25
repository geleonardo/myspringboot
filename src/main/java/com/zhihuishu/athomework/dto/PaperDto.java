package com.zhihuishu.athomework.dto;

import java.io.Serializable;
import java.util.List;

public class PaperDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private Long userId;

    private Long courseId;

    private java.sql.Date createTime;

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

    public java.sql.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.sql.Date createTime) {
        this.createTime = createTime;
    }

    public Integer getPaperType() {
        return paperType;
    }

    public void setPaperType(Integer paperType) {
        this.paperType = paperType;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolID) {
        schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "PaperDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", createTime=" + createTime +
                ", paperType=" + paperType +
                ", schoolId=" + schoolId +
                '}';
    }

    private List<PaperGroupDto> groupDtos;

    public List<PaperGroupDto> getGroupDtos() {
        return groupDtos;
    }

    public void setGroupDtos(List<PaperGroupDto> groupDtos) {
        this.groupDtos = groupDtos;
    }

}
