package com.zhihuishu.athomework.mapper.cluster;

import com.zhihuishu.athomework.dto.HomeworkAnswerDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HomeworkAnswerMapper {

    String findHomeworkAnswerID(@Param("homeworkId")  Long homeworkId,@Param("paperId")  Long paperId, @Param("userId")  Long userId, @Param("questionId")  Long questionId);

   HomeworkAnswerDto getHomeworkAnswerByID(@Param("homeworkId")  Long homeworkId,@Param("paperId")  Long paperId,@Param("userId")  Long userId,@Param("questionId")  Long questionId);

    List<HomeworkAnswerDto>  queryHomeworkAnswerByID(@Param("homeworkId") Long homeworkId,@Param("paperId") Long paperId,@Param("userId") Long userId);

    Integer updateHomeworkAnswer(HomeworkAnswerDto homeworkAnswerDto);

    Integer insertHomeworkAnswer(HomeworkAnswerDto homeworkAnswerDto);

}
