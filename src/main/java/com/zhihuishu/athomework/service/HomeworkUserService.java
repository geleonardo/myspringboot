package com.zhihuishu.athomework.service;

import com.zhihuishu.athomework.dto.HomeworkUserDto;

import java.util.HashMap;
import java.util.List;

public interface HomeworkUserService {

    //获取学生作业列表
    List<HomeworkUserDto> queryHomeworkUser(long userId);

    //获取单一学生作业
    HomeworkUserDto getHomeworkUserBySingle(long userId,long homeworkId,long paperId);
    //HomeworkUserDto getHomeworkUserBySingle(HashMap<String,Long> map);
    //获取该作业下的所有学生
    List<HomeworkUserDto> queryHomeworkUserByHPID(long homeworkId,long paperId);

    //根据组件ID 修改学生作业的信息
    Boolean updateHomeworkUserByID(HomeworkUserDto homeworkUserDto);

    //新增作业考试初始数据（仅教师端调用）
    Boolean insertHomeworkUser(long userId,long homeworkId,long paperId);

    //获取Redis中的数据
    HomeworkUserDto getHomeworkUserByRedisKey(String homeworkUserRedisKey);
}
