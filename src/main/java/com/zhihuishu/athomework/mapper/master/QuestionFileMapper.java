package com.zhihuishu.athomework.mapper.master;

import com.zhihuishu.athomework.dto.QuestionFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionFileMapper {

    List<QuestionFileDto> findQuesFileByQuesId(Long questionId);

    Integer saveQuesFileBatch(List<QuestionFileDto> quesFileDtoList);

    Integer delQuesFileByIdBatch(Long[] quesFileIds);
}
