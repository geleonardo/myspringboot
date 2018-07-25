package com.zhihuishu.athomework.dto;

import com.zhihuishu.athomework.model.PaperGroup;

import java.io.Serializable;
import java.util.List;


public class PaperGroupDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long paperId;

    private String title;

    private String brief;

    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "PaperGroup{" +
                "id=" + id +
                ", paperId=" + paperId +
                ", title='" + title + '\'' +
                ", brief='" + brief + '\'' +
                ", sort=" + sort +
                '}';
    }

    private List<QuestionDto> questionDtos;

    public List<QuestionDto> getQuestionDtos() {
        return questionDtos;
    }

    public void setQuestionDtos(List<QuestionDto> questionDtos) {
        this.questionDtos = questionDtos;
    }
}
