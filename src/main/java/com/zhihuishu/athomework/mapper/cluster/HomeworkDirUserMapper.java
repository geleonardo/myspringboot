package com.zhihuishu.athomework.mapper.cluster;

import com.zhihuishu.athomework.dto.HomeworkDirUserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HomeworkDirUserMapper {

    List<HomeworkDirUserDto> queryHomeworkDirUserByUserId(@Param("userId") Long userId);

    List<HomeworkDirUserDto> getHomeworkDirUserBySingle(@Param("homeworkId") long homeworkId,@Param("userId") long userId);

    Integer updateHomeworkDirUserByID(HomeworkDirUserDto homeworkDirUserDto);

    Integer insertHomeworkDirUser(HomeworkDirUserDto homeworkDirUserDto);
}
