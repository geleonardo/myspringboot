package com.zhihuishu.athomework.dto;


import java.io.Serializable;

public class HomeworkFileDto implements Serializable {

    private static final Long serialVersionUID = 1L;

    private  Long  id;

    private  Long homeworkId;

    private  Long paperId;

    private  Long exerciseId;

    private  Long fileId;

    private  Long userId;

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

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public Long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "HomeworkFile{" +
                "id=" + id +
                ", homeworkId=" + homeworkId +
                ", paperId=" + paperId +
                ", exerciseId=" + exerciseId +
                ", fileId=" + fileId +
                ", userId=" + userId +
                '}';
    }

}
