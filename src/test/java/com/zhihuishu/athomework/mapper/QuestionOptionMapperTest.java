package com.zhihuishu.athomework.mapper;

import com.zhihuishu.athomework.dto.QuestionOptionDto;
import com.zhihuishu.athomework.mapper.master.QuestionOptionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuestionOptionMapperTest {

    @Resource
    private QuestionOptionMapper questionOptionMapper;

    @Test
    public void testSaveQuestionOption(){
        List<QuestionOptionDto> questionOptionDtoList = new ArrayList<>();

        QuestionOptionDto questionOptionDto1 = new QuestionOptionDto();
        questionOptionDto1.setQuestionId(2L);
        questionOptionDto1.setContent("亚洲");
        questionOptionDto1.setSort(1);
        questionOptionDto1.setFrame(false);
        questionOptionDto1.setCorrect(false);

        QuestionOptionDto questionOptionDto2 = new QuestionOptionDto();
        questionOptionDto2.setQuestionId(2L);
        questionOptionDto2.setContent("美洲");
        questionOptionDto2.setSort(2);
        questionOptionDto2.setFrame(false);
        questionOptionDto2.setCorrect(false);

        QuestionOptionDto questionOptionDto3 = new QuestionOptionDto();
        questionOptionDto3.setQuestionId(2L);
        questionOptionDto3.setContent("非洲");
        questionOptionDto3.setSort(3);
        questionOptionDto3.setFrame(false);
        questionOptionDto3.setCorrect(true);

        QuestionOptionDto questionOptionDto4 = new QuestionOptionDto();
        questionOptionDto4.setQuestionId(2L);
        questionOptionDto4.setContent("大洋洲");
        questionOptionDto4.setSort(1);
        questionOptionDto4.setFrame(false);
        questionOptionDto4.setCorrect(false);

        questionOptionDtoList.add(questionOptionDto1);
        questionOptionDtoList.add(questionOptionDto2);
        questionOptionDtoList.add(questionOptionDto3);
        questionOptionDtoList.add(questionOptionDto4);

        questionOptionMapper.saveOptionBatch(questionOptionDtoList);
    }
}
