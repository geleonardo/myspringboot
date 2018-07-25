package com.zhihuishu.athomework.mapper.cluster;

import com.zhihuishu.athomework.dto.HomeWorkDirAnswerFileDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HomeworkDirAnswerFileMapper {

    HomeWorkDirAnswerFileDto getHomeworDirAnswerFile(@Param("homeworkId") Long homeworkId, @Param("userId") Long userId);

    Integer  insertHomeworDirAnswerFile (HomeWorkDirAnswerFileDto homeWorkDirAnswerFileDto);

    Integer deleteHomeworDirAnswerFile(@Param("homeworkId") Long homeworkId, @Param("userId") Long userId,@Param("fileId") Long fileId);

}
