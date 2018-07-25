package com.zhihuishu.athomework.dto;

import java.io.Serializable;

public class QuestionKenDto implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long questionId;

    private Long kenId;

    private KenDto kenDto;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public Long getKenId() {
        return kenId;
    }

    public void setKenId(Long kenId) {
        this.kenId = kenId;
    }

    public KenDto getKenDto() {
        return kenDto;
    }

    public void setKenDto(KenDto kenDto) {
        this.kenDto = kenDto;
    }
}
