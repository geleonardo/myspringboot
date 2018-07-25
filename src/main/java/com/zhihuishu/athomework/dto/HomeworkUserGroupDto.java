package com.zhihuishu.athomework.dto;

import java.io.Serializable;

public class HomeworkUserGroupDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private  Long id;

    private Long homeworkId;

    private Long classId;

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

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "HomeworkUserGroupDto{" +
                "id=" + id +
                ", homeworkId=" + homeworkId +
                ", classId=" + classId +
                '}';
    }
}
