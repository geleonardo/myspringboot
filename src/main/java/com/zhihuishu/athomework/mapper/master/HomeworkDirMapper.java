package com.zhihuishu.athomework.mapper.master;

import com.zhihuishu.athomework.dto.HomeworkDirDto;
import com.zhihuishu.athomework.dto.HomeworkDirFileDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HomeworkDirMapper {

    //直接出题 作业信息
    HomeworkDirDto findHomeworkDir(@Param("homeworkId") Long homeworkId);

    //直接出题 附件信息
    HomeworkDirFileDto findHomeworkDirFile(@Param("homeworkFileId") Long homeworkFileId);

    //直接出题 附件ID集合
    List<String> findHomeworkDirFileIDS(@Param("homeworkId") Long homeworkId);

    //直接出题 新增
    Integer insertHomeworkDirQuestion(@Param("homeworkId") Long homeworkId,@Param("content") String content,@Param("score") Double score);

}
