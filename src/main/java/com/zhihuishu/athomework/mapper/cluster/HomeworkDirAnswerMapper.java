package com.zhihuishu.athomework.mapper.cluster;


import com.zhihuishu.athomework.dto.HomeworkDirAnswerDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HomeworkDirAnswerMapper {

    HomeworkDirAnswerDto getHomeworkDirAnswerByID(@Param("homeworkId") Long homeworkId, @Param("userId") Long userId);

    Integer  updateHomeworkDirAnswer(HomeworkDirAnswerDto homeworkDirAnswerDto);

    Integer  insertHomeworkAnswer(HomeworkDirAnswerDto homeworkDirAnswerDto);
}
