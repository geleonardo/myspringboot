package com.zhihuishu.athomework.service.Impl;

import com.zhihuishu.athomework.dto.QuestionKenDto;
import com.zhihuishu.athomework.mapper.master.QuestionKenMapper;
import com.zhihuishu.athomework.service.QuestionKenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionKenServiceImpl extends BaseService implements QuestionKenService {

    @Resource
    private QuestionKenMapper questionKenMapper;

    @Override
    public List<QuestionKenDto> findQuesKenByQuesId(Long questionId) {
        List<QuestionKenDto> quesKenDtoList = null;
        try {
            quesKenDtoList = questionKenMapper.findQuesKenByQuesId(questionId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quesKenDtoList;
    }

    @Override
    public Integer saveQuesKenBatch(Long[] kenIds, Long questionId) {
        return questionKenMapper.saveQuesKenBatch(kenIds, questionId);
    }

    @Override
    public Long delQuesKenByQuesId(Long questionId) {
        return questionKenMapper.delQuesKenByQuesId(questionId);
    }
}
