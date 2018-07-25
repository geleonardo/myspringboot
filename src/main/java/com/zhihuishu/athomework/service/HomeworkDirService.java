package com.zhihuishu.athomework.service;

import com.zhihuishu.athomework.dto.HomeworkDirDto;
import com.zhihuishu.athomework.dto.HomeworkDirFileDto;

import java.util.List;

public interface HomeworkDirService {

    //直接出题 作业信息
    HomeworkDirDto findHomeworkDir(Long homeworkId);

    //直接出题 作业信息含附件列表
    HomeworkDirDto findHomeworkDirInfo(Long homeworkId);

    //直接出题 附件列表
    List<HomeworkDirFileDto> findHomeworkDirFileList(Long homeworkId);

    //直接出题 单个附件信息
    HomeworkDirFileDto findHomeworkDirFile(Long homeworkFileId);

    //直接出题 作业下附件ID集合
    List<String> findHomeworkDirFileIDS(Long homeworkId);

    //直接出题 新增
    Boolean insertHomeworkDirQuestion(Long homeworkId, String content, Double score);

}
