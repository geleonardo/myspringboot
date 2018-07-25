package com.zhihuishu.athomework.controller;

import com.zhihuishu.athomework.dto.HomeworkUserDto;

import com.zhihuishu.athomework.service.HomeworkUserService;
import com.zhihuishu.athomework.utils.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/homeworkUser")
public class HomeworkUserController {


    @Resource
    private HomeworkUserService homeworkUserService;



    @ResponseBody
    @RequestMapping("/queryHomeworkUser")
    public Json queryHomeworkUser( long userId)
    {
        Json json = new Json();
        try {
            userId=1;
            List<HomeworkUserDto> homeworkUserDtoList = homeworkUserService.queryHomeworkUser(userId);
            json.setSuccessValue(homeworkUserDtoList);
        } catch (Exception e){
            json.setExceptionValue(e);
        }
        return json;
    }

    @ResponseBody
    @RequestMapping("/getHomeworkUserBySingle")
    public Json getHomeworkUserBySingle( long homeworkId,long paperId,long userId)
    {
        Json json = new Json();
        try {
            userId=1;
            homeworkId=1;
            paperId=1;
            HomeworkUserDto model = homeworkUserService.getHomeworkUserBySingle(userId,homeworkId,paperId);
            json.setSuccessValue(model);
        } catch (Exception e){
            json.setExceptionValue(e);
        }
        return json;
    }

    @ResponseBody
    @RequestMapping("/queryHomeworkUserByHPID")
    public Json queryHomeworkUserByHPID (long homeworkId,long paperId)
    {
        Json json = new Json();
        try {

            homeworkId=1;
            paperId=1;
            List<HomeworkUserDto> model = homeworkUserService.queryHomeworkUserByHPID(homeworkId,paperId);
            json.setSuccessValue(model);
        } catch (Exception e){
            json.setExceptionValue(e);
        }
        return json;
    }

    @ResponseBody
    @RequestMapping("/updateHomeworkUserByID")
    public Json updateHomeworkUserByID (HomeworkUserDto homeworkUserDto)
    {
        Json json = new Json();
        try {
            homeworkUserDto.setUserId(1L);

           Boolean b= homeworkUserService.updateHomeworkUserByID(homeworkUserDto);
            json.setSuccessValue(b);
        } catch (Exception e){
            json.setExceptionValue(e);
        }
        return json;
    }



    /**
     * @Description  提交作业
     * @author weiyi
     * @date 2018-7-19
     */
    @ResponseBody
    @RequestMapping("/submitHomeworkUser")
    public Json submitHomeworkUser( )
    {

        return null;
    }




}
