package com.zhihuishu.athomework.controller;

import com.zhihuishu.athomework.dto.PaperDto;
import com.zhihuishu.athomework.dto.PaperGroupDto;
import com.zhihuishu.athomework.dto.PaperQuestionDto;
import com.zhihuishu.athomework.dto.QuestionDto;
import com.zhihuishu.athomework.model.Paper;
import com.zhihuishu.athomework.model.PaperGroup;
import com.zhihuishu.athomework.model.Question;
import com.zhihuishu.athomework.service.PaperGroupService;
import com.zhihuishu.athomework.service.PaperQuestionService;
import com.zhihuishu.athomework.service.PaperService;
import com.zhihuishu.athomework.service.QuestionService;
import com.zhihuishu.athomework.utils.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/paper")
public class PaperController {

    @Resource
    private PaperService paperService;

    /**
     * @param paperId 试卷ID
     * @Description 获取试卷信息
     * @author zhouxiyu
     * @date 2018-7-19
     */
    @ResponseBody
    @RequestMapping("/findPaperInfo")
    public Json findPaperInfo(Long paperId) {
        Json json = new Json();
        PaperDto paperDto=null;
        try {
            paperDto = paperService.findPaperInfo(paperId);
            json.setSuccessValue(paperDto);
        } catch (Exception e) {
            json.setExceptionValue(e);
        }
        return json;
    }


    /**
     * @Description 根据id更新paper
     * @author lvxiangjun
     * @date 2018-7-13 17:43:34
     */
    @ResponseBody
    @RequestMapping("/updatePaperDemo")
    public Json updatePaperDemo(PaperDto paperDto) {
        System.out.println(paperDto);
        Json json = new Json();
        try {
            Integer result = paperService.updatePaperDemo(paperDto);
            if (result == 1) {
                json.setSuccessValue("更新成功");
            } else {
                json.setExceptionValue("更新失败:" + result);
            }
        } catch (Exception e) {
            json.setExceptionValue(e);
        }
        return json;
    }

    /**
     * @Description 单条插入paper
     * @author lvxiangjun
     * @date 2018-7-13 17:47:18
     */
    @ResponseBody
    @RequestMapping("/insertPaperDemo")
    public Json insertPaperDemo(PaperDto paperDto) {
        System.out.println(paperDto);
        Json json = new Json();
        try {
            Integer result = paperService.insertPaperDemo(paperDto);
            if (result == 1) {
                json.setSuccessValue("更新成功");
            } else {
                json.setExceptionValue("更新失败:" + result);
            }
        } catch (Exception e) {
            json.setExceptionValue(e);
        }
        return json;
    }
}
