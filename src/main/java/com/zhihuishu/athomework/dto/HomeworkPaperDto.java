package com.zhihuishu.athomework.dto;

import java.io.Serializable;

public class HomeworkPaperDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private  Long id;

    private  Long homeworkId;

    private  Long paperId;

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

    @Override
    public String toString() {
        return "HomeworkPaperDto{" +
                "id=" + id +
                ", homeworkId=" + homeworkId +
                ", paperId=" + paperId +
                '}';
    }
}
