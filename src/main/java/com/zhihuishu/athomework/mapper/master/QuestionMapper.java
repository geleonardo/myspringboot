package com.zhihuishu.athomework.mapper.master;

import com.zhihuishu.athomework.dto.QuestionDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {

    /**
     * @Description 根据Id获取题目的所有信息以及选项
     * @author lvxiangjun
     * @param questionId
     * @date 2018-7-23 15:29:02
     */
    QuestionDto findQuestionInfo(Long questionId);

    /**
     * @Description 插入题目的基本信息
     * @author lvxiangjun
     * @param questionDto 包含题目的基本信息
     * @date 2018-7-17 16:03:25
     */
    Integer saveQuestionInfo(QuestionDto questionDto);

    Integer updateQuestionInfo(QuestionDto questionDto);

    /**
     * @Description 逻辑删除题目
     * @author lvxiangjun
     * @param questionId
     * @date 2018-7-18 09:09:30
     */
    Integer delQuesLogically(Long questionId);
}