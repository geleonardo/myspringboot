package com.zhihuishu.athomework.service;

import com.zhihuishu.athomework.dto.HomeworkFileDto;
import org.springframework.stereotype.Service;

@Service
public interface HomeworkFileService  {

    //根据ID，获取单一文件的FileID
    Integer getHomeworFileID(Long homeworkId,Long paperId,Long userId,Long exerciseId);

    //新增(上传)File
    Integer insertHomeworkFile(HomeworkFileDto homeworkFileDto);



}
