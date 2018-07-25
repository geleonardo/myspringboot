package com.zhihuishu.athomework.mapper.master;

import com.zhihuishu.athomework.dto.QuestionCourseDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface QuestionCourseMapper {

    List<QuestionCourseDto> findQuesCourseByQuesId(Long questionId);

    boolean IsExistDupli(QuestionCourseDto questionCourseDto);

    Integer saveQuesCourse(QuestionCourseDto questionCourseDto);

    Integer saveQuesCourseBatch(@Param("questionCourseSet") Set<QuestionCourseDto> questionCourseSet);

    Integer delQuesCourseByQuesId(Long questionId);
}
