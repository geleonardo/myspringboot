package com.zhihuishu.athomework.service;

import com.zhihuishu.athomework.dto.HomeworkAnswerDto;

public interface HomeworkAnswerService {


    //是否存在homeworkAnswer数据
    Boolean isExists(Long homeworkId,Long paperId,Long userId,Long questionId);

    //获取单一作业答案
    HomeworkAnswerDto getHomeworkAnswerByID(Long homeworkId,Long paperId,Long userId,Long questionId);

    //修改作业答案
    void setHomeworkAnswer(HomeworkAnswerDto homeworkAnswerDto);

    //根据RedisKey获取学生答案
    HomeworkAnswerDto getHomeworkAnswerByRedisKey(String homeworkAnswerRedisKey);

    //计算习题得分
    HomeworkAnswerDto  calculateHomeworkAnswerScore(HomeworkAnswerDto homeworkAnswerDto);

    //修改作业答案（入库）
    Integer updateHomeworkAnswer(HomeworkAnswerDto homeworkAnswerDto);

    //新增作业答案（入库）
    Integer insertHomeworkAnswer(HomeworkAnswerDto homeworkAnswerDto);



}
