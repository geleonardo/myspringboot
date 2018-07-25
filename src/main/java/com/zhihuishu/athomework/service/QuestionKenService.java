package com.zhihuishu.athomework.service;

import com.zhihuishu.athomework.dto.QuestionKenDto;

import java.util.List;

public interface QuestionKenService {

    List<QuestionKenDto> findQuesKenByQuesId(Long questionId);

    Integer saveQuesKenBatch(Long[] kenIds, Long questionId);

    Long delQuesKenByQuesId(Long questionId);
}
