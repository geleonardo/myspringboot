package com.zhihuishu.athomework.mapper.cluster;

import com.zhihuishu.athomework.dto.HomeworkFileDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HomeworkFileMapper {

    Integer getHomeworFileID(@Param("homeworkId") Long homeworkId, @Param("paperId") Long paperId,@Param("userId")  Long userId, @Param("exerciseId")  Long exerciseId);

    Integer insertHomeworkFile(HomeworkFileDto homeworkFileDto);


}
