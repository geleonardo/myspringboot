package com.zhihuishu.athomework.mapper.cluster;

import com.zhihuishu.athomework.dto.HomeworkUserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface HomeworkUserMapper {

    //获取学生作业列表
    List<HomeworkUserDto> queryHomeworkUser(@Param("userId") long userId);

    //获取单一学生作业
    HomeworkUserDto getHomeworkUserBySingle(@Param("userId") long userId, @Param("homeworkId") long homeworkId,@Param("paperId") long paperId);

    //获取该作业下的所有学生
    List<HomeworkUserDto> queryHomeworkUserByHPID(@Param("homeworkId") long homeworkId,@Param("paperId") long paperId);

    //根据组件ID 修改学生作业的信息
    Integer updateHomeworkUserByID(HomeworkUserDto homeworkUserDto);

    //新增学生作业信息
    Integer insertHomeworkUser(HomeworkUserDto homeworkUserDto);

}
