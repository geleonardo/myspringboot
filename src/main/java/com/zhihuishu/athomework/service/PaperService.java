package com.zhihuishu.athomework.service;

import com.zhihuishu.athomework.dto.PaperDto;
import com.zhihuishu.athomework.dto.PaperQuestionDto;
import com.zhihuishu.athomework.dto.QuestionOptionDto;
import com.zhihuishu.athomework.model.Paper;

import java.util.List;

public interface PaperService {

    /**
     * @Description  试卷信息
     * @author zhouxiyu
     * @param paperId  试卷ID
     * @date 2018-7-19
     */
    PaperDto findPaperInfo(Long paperId);

    /**
     * @Description 更新指定id的paper信息
     * @author lvxiangjun
     * @param paperDto
     * @date 2018-7-13 17:32:25
     */
    Integer updatePaperDemo(PaperDto paperDto);

    /**
     * @Description 根据分页参数查询page的一个demo
     * @author lvxiangjun
     * @param paperDto
     * @date 2018-7-13 17:32:29
     */
    Integer insertPaperDemo(PaperDto paperDto);
}
