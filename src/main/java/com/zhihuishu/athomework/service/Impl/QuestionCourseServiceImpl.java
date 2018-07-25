package com.zhihuishu.athomework.service.Impl;

import com.zhihuishu.athomework.dto.QuestionCourseDto;
import com.zhihuishu.athomework.mapper.master.QuestionCourseMapper;
import com.zhihuishu.athomework.service.QuestionCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service
public class QuestionCourseServiceImpl extends BaseService implements QuestionCourseService {

    @Resource
    private QuestionCourseMapper questionCourseMapper;

    @Override
    public List<QuestionCourseDto> findQuesCourseByQuesId(Long questionId) {
        List<QuestionCourseDto> quesCourseDtoList = null;
        try {
            quesCourseDtoList = questionCourseMapper.findQuesCourseByQuesId(questionId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quesCourseDtoList;
    }

    @Override
    public boolean IsExistDupli(QuestionCourseDto questionCourseDto) {
        return questionCourseMapper.IsExistDupli(questionCourseDto);
    }

    @Override
    public Integer saveQuesCourse(QuestionCourseDto questionCourseDto) {
        return questionCourseMapper.saveQuesCourse(questionCourseDto);
    }

    @Override
    public Integer saveQuesCourseBatch(Set<QuestionCourseDto> questionCourseSet) {
        return questionCourseMapper.saveQuesCourseBatch(questionCourseSet);
    }

    @Override
    public Integer delQuesCourseByQuesId(Long questionId) {
        return questionCourseMapper.delQuesCourseByQuesId(questionId);
    }
}
