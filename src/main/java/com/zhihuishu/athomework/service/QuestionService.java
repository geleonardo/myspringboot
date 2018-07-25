package com.zhihuishu.athomework.service;

import com.zhihuishu.athomework.dto.*;

import java.util.List;

public interface QuestionService {

    /**
     * @Description 根据题目id获取题目的基本信息
     * @author lvxiangjun
     * @param questionId
     * @date 2018-7-24 10:08:33
     */
    QuestionDto findQuesBaseInfo(Long questionId);

    /**
     * @Description 根据题目id获取题目的基本信息+选项信息、附件信息
     * @author lvxiangjun
     * @param questionId
     * @date 2018-7-24 10:08:33
     */
    QuestionDto findQuestionInfo(Long questionId);

    /**
     * @Description 根据题目id获取题目的基本信息+选项信息、附件信息、知识点关联、知识点信息
     * @author lvxiangjun
     * @param questionId
     * @date 2018-7-24 10:08:33
     */
    QuestionDto findQuesDetailInfo(Long questionId);

    Boolean saveChoiceQuesManually(QuestionDto questionDto, List<QuestionFileDto> questionFileDtoList, List<KenDto> kenDtoList,
                                   List<QuestionOptionDto> questionOptionDtoList, List<QuestionCourseDto> questionCourseDtoList);

    Boolean saveFillingQuesManually(QuestionDto questionDto, List<QuestionFileDto> questionFileDtoList, List<KenDto> kenDtoList,
                                    List<QuestionOptionDto> questionOptionDtoList, List<QuestionCourseDto> questionCourseDtoList);

    Boolean saveJudgeQuesManually(QuestionDto questionDto, List<QuestionFileDto> questionFileDtoList, List<KenDto> kenDtoList,
                                    List<QuestionCourseDto> questionCourseDtoList);

    Boolean saveAnswerQuesManually(QuestionDto questionDto, List<QuestionFileDto> questionFileDtoList, List<KenDto> kenDtoList,
                                    List<QuestionCourseDto> questionCourseDtoList);

    Boolean saveComboQuesManually(QuestionDto mainQuestionDto, List<QuestionDto> subQuestionDtoList,
                                  List<QuestionFileDto> questionFileDtoList, List<KenDto> kenDtoList, List<QuestionCourseDto> questionCourseDtoList);

    Boolean updateChoiceQues(QuestionDto questionDto, Long[] delFileIds, List<QuestionFileDto> addFileDtoList, Long[] delOptionIds,
                             List<QuestionOptionDto> addQuesOptionDtoList, List<QuestionCourseDto> questionCourseDtoList,
                             List<KenDto> kenDtoList);

    Boolean deleteQuesLogically(Long questionId);

}
