package com.zhihuishu.athomework.controller;

import com.zhihuishu.athomework.dto.HomeworkFileDto;
import com.zhihuishu.athomework.service.HomeworkFileService;
import com.zhihuishu.athomework.utils.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/HomeworkFile")
public class HomeworkFileController {

    private HomeworkFileService homeworkFileService;


    //获取学生单一作业下所有附件信息
    public Json QueryHomeworkUserFile(Long homeworkId,Long paperId,Long userId,Long exerciseId)
    {
        return  null;
    }

    //删除作业附件
    public Json DelHomewrokUserFile(Integer Id)
    {
        return  null;
    }

    //新增作业附件
    public Json InsertHomewrokUserFile(HomeworkFileDto homeworkFileDto)
    {
        return  null;
    }



}
