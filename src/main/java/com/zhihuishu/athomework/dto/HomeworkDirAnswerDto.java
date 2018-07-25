package com.zhihuishu.athomework.dto;

import java.io.Serializable;

public class HomeworkDirAnswerDto implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Long id;

    private Long homeworkId;

    private Long   userId;

    private String answer;

    private Double   score;

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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
