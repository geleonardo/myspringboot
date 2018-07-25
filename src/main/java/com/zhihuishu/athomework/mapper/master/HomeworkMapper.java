package com.zhihuishu.athomework.mapper.master;

import com.zhihuishu.athomework.dto.HomeworkDirDto;
import com.zhihuishu.athomework.dto.HomeworkDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HomeworkMapper {

    //题目组卷
    HomeworkDto findHomeworkInfo(@Param("homeworkId") Long homeworkId);

    List<HomeworkDto> findHomeworkList(Long userId, Integer status);

    Long insertHomework(HomeworkDto homeworkDto);

    Integer updateHomework(HomeworkDto homeworkDto);

    void deleteHomeworkClass(Long homeworkId);

    Long insertHomeworkClass(@Param("homeworkId") Long homeworkId, @Param("classId") Long classId);
}
