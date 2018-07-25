package com.zhihuishu.athomework.service;

import com.zhihuishu.athomework.dto.QuestionDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionServiceTest {
    @Resource
    private QuestionService questionService;

    @Test
    public void testSaveChoiceQuesManually(){
        QuestionDto questionDto = new QuestionDto();
        questionService.saveChoiceQuesManually(questionDto, null, null, null, null);
        System.out.println(questionDto.getId());
    }

    @Test
    public void testFindQuestionInfo(){
        QuestionDto questionDto = questionService.findQuestionInfo(2L);
        System.out.println("success");
    }

}
