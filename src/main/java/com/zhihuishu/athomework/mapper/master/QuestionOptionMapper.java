package com.zhihuishu.athomework.mapper.master;

import com.zhihuishu.athomework.dto.QuestionOptionDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionOptionMapper {

    List<QuestionOptionDto> findOptionByQuesId(Long questionId);

    Integer saveOptionBatch(List<QuestionOptionDto> questionOptionDtoList);

    Integer delOptionBatch(Long[] questionOptionIds);
}
