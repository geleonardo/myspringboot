package com.zhihuishu.athomework.service;

import com.zhihuishu.athomework.dto.QuestionCourseDto;

import java.util.List;
import java.util.Set;

public interface QuestionCourseService {

    List<QuestionCourseDto> findQuesCourseByQuesId(Long questionId);

    boolean IsExistDupli(QuestionCourseDto questionCourseDto);

    Integer saveQuesCourse(QuestionCourseDto questionCourseDto);

    Integer saveQuesCourseBatch(Set<QuestionCourseDto> questionCourseSet);

    Integer delQuesCourseByQuesId(Long questionId);
}
