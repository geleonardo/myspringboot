package com.zhihuishu.athomework.model;

import java.io.Serializable;

public class QuestionCourse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long questionId; //习题编号

    private Long courseId; //习题关联的课程编号

    private Long folderId; //习题关联的章节编号

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getFolderId() {
        return folderId;
    }

    public void setFolderId(Long folderId) {
        this.folderId = folderId;
    }
}
