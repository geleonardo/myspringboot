package com.zhihuishu.athomework.mapper.cluster;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamAnswerMapper {

//    @Select(" select ExamID from AT_homeworkExamAnswer.ExamAnswer where ID = 1 ")
    Long getID();
}
