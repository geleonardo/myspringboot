package com.zhihuishu.athomework.mapper.master;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperQuestionMapper {

    List<String> findPaperQuestionIDS(@Param("groupId") Long groupId);

}
