package com.zhihuishu.athomework.service;

import com.zhihuishu.athomework.dto.QuestionOptionDto;

import java.util.List;

public interface QuestionOptionService {

    List<QuestionOptionDto> findOptionByQuesId(Long questionId);

    Integer saveOptionBatch(List<QuestionOptionDto> questionOptionDtoList);

    Integer delOptionBatch(Long[] questionOptionIds);
}
