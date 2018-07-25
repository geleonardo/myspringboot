package com.zhihuishu.athomework.controller;

import com.zhihuishu.athomework.dto.HomeworkAnswerDto;
import com.zhihuishu.athomework.service.HomeworkAnswerService;
import com.zhihuishu.athomework.utils.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/homeworkAnswer")
public class HomeworkAnswerController {

    @Resource
    private HomeworkAnswerService homeworkAnswerService;



    /**
     * @Description  设置习题答案
     * @author weiyi
     * @date 2018-7-19
     */
    @ResponseBody
    @RequestMapping("/setHomeworkAnswer")
    public Json setHomeworkAnswer(HomeworkAnswerDto homeworkAnswerDto)
    {
        Json json = new Json();
        try
        {
            homeworkAnswerDto.setUserId(1L);
            homeworkAnswerService.setHomeworkAnswer(homeworkAnswerDto);
            json.setSuccessValue("OK");
        }
        catch (Exception e){
            json.setExceptionValue(e);
        }
        return json;
    }






}

