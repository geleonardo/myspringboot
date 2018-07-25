package com.zhihuishu.athomework.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class PaperQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    private  Long id;

    private  Long paperId;

    private Long paperGroupId;

    private Long questionId;

    private Long questionPId;

    private  Integer sort;

    private BigDecimal score;

    private Integer isCancel;

    @Override
    public String toString() {
        return "PaperQuestion{" +
                "id=" + id +
                ", paperId=" + paperId +
                ", paperGroupId=" + paperGroupId +
                ", questionId=" + questionId +
                ", questionPId=" + questionPId +
                ", sort=" + sort +
                ", score=" + score +
                ", isCancel=" + isCancel +
                '}';
    }
}
