package com.zhihuishu.athomework.controller;

import com.zhihuishu.athomework.dto.HomeWorkDirAnswerFileDto;
import com.zhihuishu.athomework.dto.HomeworkDirAnswerDto;
import com.zhihuishu.athomework.dto.HomeworkUserDto;
import com.zhihuishu.athomework.model.SeachHomeworkDirUser;
import com.zhihuishu.athomework.utils.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/homeworkUserDir")
public class HomeworkDirUserController {

    //获取学生直接出题下的作业
    @ResponseBody
    @RequestMapping(value = "/queryHomeworkUser",method = RequestMethod.GET)
    public Json queryHomeworkDirUser(long courseId,long userId) {
        return null;
    }

    //获取学生直接出题下的作业（分页，内容搜索）
    @ResponseBody
    @RequestMapping(value = "/queryHomeworkUserByPage",method = RequestMethod.GET)
    public Json queryHomeworkDirUser(SeachHomeworkDirUser seachHomeworkDirUser) {
        return null;
    }

    //获取学生直接出题Model
    @ResponseBody
    @RequestMapping(value = "/getHomeworkDirUserBySingle",method = RequestMethod.GET)
    public Json getHomeworkDirUserBySingle(long courseId,long userId,long homeworkId)
    {
        return null;
    }


    //作业提交
    @ResponseBody
    @RequestMapping(value = "/submitHomeworkDirUser",method = RequestMethod.POST)
    public Json submitHomeworkDirUser(HomeworkDirAnswerDto homeworkDirAnswerDto)
    {
        return null;
    }


    //获取该学生下的作业附件列表
    @ResponseBody
    @RequestMapping(value = "/queryHomeworkDirAnswerFile",method = RequestMethod.GET)
    public Json queryHomeworkDirAnswerFile(long courseId,long userId,long homeworkId)
    {
        return null;
    }

    //上传附件
    @ResponseBody
    @RequestMapping(value = "/addHomeworkDirAnswerFile",method = RequestMethod.POST)
    public Json addHomeworkDirAnswerFile(HomeWorkDirAnswerFileDto homeWorkDirAnswerFileDto)
    {
        return null;
    }

    //删除附件
    @ResponseBody
    @RequestMapping(value = "/queryHomeworkUserByPage",method = RequestMethod.POST)
    public Json delHomeworkDirAnswerFile(long courseId,long userId,long homeworkId,long fileId)
    {
        return null;
    }


}
