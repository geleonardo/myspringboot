package com.zhihuishu.athomework.mapper.master;

import com.zhihuishu.athomework.dto.QuestionKenDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QuestionKenMapper {

    List<QuestionKenDto> findQuesKenByQuesId(Long questionId);

    Integer saveQuesKenBatch(@Param("kenIds") Long[] kenIds, @Param("questionId") Long questionId);

    Long delQuesKenByQuesId(Long questionId);
}
