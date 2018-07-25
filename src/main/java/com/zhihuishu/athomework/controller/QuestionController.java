package com.zhihuishu.athomework.controller;

import com.alibaba.fastjson.JSON;
import com.zhihuishu.athomework.dto.*;
import com.zhihuishu.athomework.service.KenService;
import com.zhihuishu.athomework.service.QuestionOptionService;
import com.zhihuishu.athomework.service.QuestionService;
import com.zhihuishu.athomework.utils.Json;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionOptionService questionOptionService;

    @ResponseBody
    @RequestMapping("/createChoiceQuesManually")
    public Json createChoiceQuesManually(String questionJson, String quesFileListJson, String kenListJson, String quesOptionListJson,
                                         String quesCourseListJson){
        Json json = new Json();

        try {
            QuestionDto questionDto = JSON.parseObject(questionJson, QuestionDto.class);
            List<QuestionFileDto> questionFileDtoList = JSON.parseArray(quesFileListJson, QuestionFileDto.class);
            List<KenDto> kenDtoList = JSON.parseArray(kenListJson, KenDto.class);
            List<QuestionOptionDto> questionOptionDtoList = JSON.parseArray(quesOptionListJson, QuestionOptionDto.class);
            List<QuestionCourseDto> questionCourseDtoList = JSON.parseArray(quesCourseListJson, QuestionCourseDto.class);

            Long userId = 2L; //todo 调用接口获得userId
            questionDto.setFrom(1); //标识为手动创建
            questionDto.setCreateTime(new Date());
            questionDto.setDisplay(true); //默认展示
            questionDto.setUserId(userId);

            for (KenDto kenDto : kenDtoList) {
                kenDto.setUserId(userId);
            }

            Boolean result = questionService.saveChoiceQuesManually(questionDto, questionFileDtoList, kenDtoList,
                    questionOptionDtoList, questionCourseDtoList);

            if(result){
                json.setSuccessValue("建题成功");
            } else {
                json.setExceptionValue("建题失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setExceptionValue(e);
        }
        return json;
    }

    @ResponseBody
    @RequestMapping("/createJudgeQuesManually")
    public Json createJudgeQuesManually(String questionJson, String quesFileListJson, String kenListJson, String quesCourseListJson){
        Json json = new Json();

        try {
            QuestionDto questionDto = JSON.parseObject(questionJson, QuestionDto.class);
            List<QuestionFileDto> quesFileDtoList = JSON.parseArray(quesFileListJson, QuestionFileDto.class);
            List<KenDto> kenDtoList = JSON.parseArray(kenListJson, KenDto.class);
            List<QuestionCourseDto> quesCourseDtoList = JSON.parseArray(quesCourseListJson, QuestionCourseDto.class);

            Long userId = 2L; //todo 调用接口获得userId
            questionDto.setQuestionTypeId(1);
            questionDto.setFrom(1); //标识为手动创建
            questionDto.setCreateTime(new Date());
            questionDto.setDisplay(true); //默认展示
            questionDto.setUserId(userId);

            for (KenDto kenDto : kenDtoList) {
                kenDto.setUserId(userId);
            }

            Boolean result = questionService.saveJudgeQuesManually(questionDto, quesFileDtoList, kenDtoList, quesCourseDtoList);

            if(result){
                json.setSuccessValue("建题成功");
            } else {
                json.setExceptionValue("建题失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setExceptionValue(e);
        }
        return json;
    }

    @ResponseBody
    @RequestMapping("/createFillingQuesManually")
    public Json createFillingQuesManually(String questionJson, String quesFileListJson, String kenListJson, String quesOptionListJson,
                                          String quesCourseListJson){
        Json json = new Json();

        try {
            QuestionDto questionDto = JSON.parseObject(questionJson, QuestionDto.class);
            List<QuestionFileDto> quesFileDtoList = JSON.parseArray(quesFileListJson, QuestionFileDto.class);
            List<KenDto> kenDtoList = JSON.parseArray(kenListJson, KenDto.class);
            List<QuestionOptionDto> questionOptionDtoList = JSON.parseArray(quesOptionListJson, QuestionOptionDto.class);
            List<QuestionCourseDto> questionCourseDtoList = JSON.parseArray(quesCourseListJson, QuestionCourseDto.class);

            Long userId = 2L; //todo 调用接口获得userId
            questionDto.setQuestionTypeId(4);
            questionDto.setFrom(1); //标识为手动创建
            questionDto.setCreateTime(new Date());
            questionDto.setDisplay(true); //默认展示
            questionDto.setUserId(userId);

            for (KenDto kenDto : kenDtoList) {
                kenDto.setUserId(userId);
            }

            Boolean result = questionService.saveFillingQuesManually(questionDto, quesFileDtoList, kenDtoList,
                    questionOptionDtoList, questionCourseDtoList);

            if(result){
                json.setSuccessValue("建题成功");
            } else {
                json.setExceptionValue("建题失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setExceptionValue(e);
        }

        return json;
    }

    @ResponseBody
    @RequestMapping("/createAnswerQuesManually")
    public Json createAnswerQuesManually(String questionJson, String quesFileListJson, String kenListJson,
                                         String quesCourseListJson){
        Json json = new Json();

        try {
            QuestionDto questionDto = JSON.parseObject(questionJson, QuestionDto.class);
            List<QuestionFileDto> quesFileDtoList = JSON.parseArray(quesFileListJson, QuestionFileDto.class);
            List<KenDto> kenDtoList = JSON.parseArray(kenListJson, KenDto.class);
            List<QuestionCourseDto> quesCourseDtoList = JSON.parseArray(quesCourseListJson, QuestionCourseDto.class);

            Assert.notNull(questionDto.getDiff(), "题目难度不能为空");

            Long userId = 2L; //todo 调用接口获得userId
            questionDto.setQuestionTypeId(5);
            questionDto.setFrom(1); //标识为手动创建
            questionDto.setCreateTime(new Date());
            questionDto.setDisplay(true); //默认展示
            questionDto.setUserId(userId);

            //赋值知识点的创建人id
            for (KenDto kenDto : kenDtoList) {
                kenDto.setUserId(userId);
            }

            Boolean result = questionService.saveAnswerQuesManually(questionDto, quesFileDtoList, kenDtoList, quesCourseDtoList);

            if(result){
                json.setSuccessValue("建题成功");
            } else {
                json.setExceptionValue("建题失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setExceptionValue(e);
        }

        return json;
    }

    @ResponseBody
    @RequestMapping("/createComboQuesManually")
    public Json createComboQuesManually(String mainQuestionJson, String subQuestionListJson, String quesFileListJson,
                                        String kenListJson, String quesCourseListJson){
        Json json = new Json();

        try {
            QuestionDto mainQuestionDto = JSON.parseObject(mainQuestionJson, QuestionDto.class);
            List<QuestionDto> subQuestionDtoList = JSON.parseArray(subQuestionListJson, QuestionDto.class);
            List<QuestionFileDto> quesFileDtoList = JSON.parseArray(quesFileListJson, QuestionFileDto.class);
            List<KenDto> kenDtoList = JSON.parseArray(kenListJson, KenDto.class);
            List<QuestionCourseDto> questionCourseDtoList = JSON.parseArray(quesCourseListJson, QuestionCourseDto.class);

            Long userId = 2L; //todo 调用接口获得userId
            mainQuestionDto.setQuestionTypeId(6);
            mainQuestionDto.setFrom(1); //标识为手动创建
            mainQuestionDto.setCreateTime(new Date());
            mainQuestionDto.setDisplay(true); //默认展示
            mainQuestionDto.setUserId(userId);

            for (KenDto kenDto : kenDtoList) {
                kenDto.setUserId(userId);
            }

            Boolean result = questionService.saveComboQuesManually(mainQuestionDto, subQuestionDtoList, quesFileDtoList, kenDtoList, questionCourseDtoList);

            if(result){
                json.setSuccessValue("建题成功");
            } else {
                json.setExceptionValue("建题失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            json.setExceptionValue(e);
        }
        return json;
    }


    /**
     * @Description 根据题目id提取相关数据，转到已创建的题目编辑视图
     * @author lvxiangjun
     * @param questionId 题目id
     * @date 2018-7-23 10:12:04
     * @return 题目编辑视图
     */
    @ResponseBody
    @RequestMapping("/editQuestion")
    public Json editQuestion(Long questionId){
        Json json = new Json();

        QuestionDto questionDto = questionService.findQuesDetailInfo(questionId);

        //如果为选择题，查询出选项信息
        Integer questionTypeId = questionDto.getQuestionTypeId();
        if(questionTypeId == 2 || questionTypeId == 3){
            List<QuestionOptionDto> quesOptionDtoList = questionOptionService.findOptionByQuesId(questionId);
            questionDto.setQuestionOptionDtoList(quesOptionDtoList);
        }

        json.setSuccessValue(questionDto);
        return json;
    }

    @ResponseBody
    @RequestMapping("/updateChiceQues")
    public Json updateChoiceQues(String questionJson, Long[] delFileIds, String addQuesFileListJson, Long[] delOptionIds,
                                 String addOptionListJson, String kenListJson, String quesCourseListJson){

        Json json = new Json();

        try {
            QuestionDto questionDto = JSON.parseObject(questionJson, QuestionDto.class);
            List<QuestionFileDto> addQuesFileDtoList = JSON.parseArray(addQuesFileListJson, QuestionFileDto.class);
            List<QuestionOptionDto> addOptionDtoList = JSON.parseArray(addOptionListJson, QuestionOptionDto.class);
            List<KenDto> kenDtoList = JSON.parseArray(kenListJson, KenDto.class);
            List<QuestionCourseDto> questionCourseDtoList = JSON.parseArray(quesCourseListJson, QuestionCourseDto.class);

            questionService.updateChoiceQues(questionDto, delFileIds, addQuesFileDtoList, delOptionIds, addOptionDtoList,
                    questionCourseDtoList, kenDtoList);

        } catch (Exception e){
            e.printStackTrace();

        }
        return json;
    }

}
