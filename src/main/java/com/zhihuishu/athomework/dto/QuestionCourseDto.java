package com.zhihuishu.athomework.dto;

import java.io.Serializable;


public class QuestionCourseDto implements Serializable{

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

    @Override
    public int hashCode() {
        int result = 1;
        int elementHash;
        if(questionId != null){
            elementHash = (int)(questionId ^ (questionId >>> 32));
            result = 31 * result + elementHash;
        }
        if(courseId != null){
            elementHash = (int)(courseId ^ (courseId >>> 32));
            result = 31 * result + elementHash;
        }
        if(folderId != null){
            elementHash = (int)(folderId ^ (folderId >>> 32));
            result = 31 * result + elementHash;
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QuestionCourseDto) {
            QuestionCourseDto anotherObj = (QuestionCourseDto)obj;
            long param1 = questionId == null ? 0 : questionId;
            long param2 = courseId == null ? 0 : courseId;
            long param3 = folderId == null ? 0 :folderId;
            long anoParam1 = anotherObj.getQuestionId() == null ? 0 : anotherObj.getQuestionId();
            long anoParam2 = anotherObj.getCourseId() == null ? 0 : anotherObj.getCourseId();
            long anoParam3 = anotherObj.getFolderId() == null ? 0 : anotherObj.getFolderId();
            return param1 == anoParam1 && param2 == anoParam2 && param3 == anoParam3;
        }
        return false;
    }
}
