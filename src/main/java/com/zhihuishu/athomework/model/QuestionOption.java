package com.zhihuishu.athomework.model;

import java.io.Serializable;

public class QuestionOption implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id; //选项表id

    private Long questionId; //试题id

    private String content; //选项内容

    private Integer sort; //序号

    private Boolean isCorrect; //是否为正确答案

    private Boolean isFrame; //是否富文本输入

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public Boolean getFrame() {
        return isFrame;
    }

    public void setFrame(Boolean frame) {
        isFrame = frame;
    }
}
