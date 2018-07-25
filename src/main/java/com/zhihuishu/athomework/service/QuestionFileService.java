package com.zhihuishu.athomework.service;

import com.zhihuishu.athomework.dto.QuestionFileDto;

import java.util.List;

public interface QuestionFileService {

    List<QuestionFileDto> findQuesFileByQuesId(Long questionId);

    Integer saveQuesFileBatch(List<QuestionFileDto> quesFileDtoList);

    Integer delQuesFileByIdBatch(Long[] quesFileIds);
}
