package com.zhihuishu.athomework.dto;


import java.io.Serializable;

public class HomeworkAnswerDto   implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Long id;

    private Long homeworkId;

    private Long  paperId;

    private Long questionId;

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

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
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

    @Override
    public String toString() {
        return "HomeworkAnswer{" +
                "id=" + id +
                ", homeworkId=" + homeworkId +
                ", paperId=" + paperId +
                ", questionId=" + questionId +
                ", userId=" + userId +
                ", answer='" + answer + '\'' +
                ", score=" + score +
                '}';
    }


}
