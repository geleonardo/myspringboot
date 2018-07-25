package com.zhihuishu.athomework.mapper;

import com.zhihuishu.athomework.dto.QuestionDto;
import com.zhihuishu.athomework.mapper.master.QuestionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionMapperTest {

    @Resource
    private QuestionMapper questionMapper;

    @Test
    public void testSaveChoiceQues(){
        QuestionDto questionDto = new QuestionDto();
        questionMapper.saveQuestionInfo(questionDto);
        System.out.println(questionDto.getId());
    }

    @Test
    public void testGetChoiceQuesDetailById(){
        QuestionDto questionDto = questionMapper.findQuestionInfo(2L);
        System.out.println(questionDto);
    }

}
