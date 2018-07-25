package com.zhihuishu.athomework.mapper.master;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeworkPaperMapper {

    Long findPaperID(Long homeworkId);

}
