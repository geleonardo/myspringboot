package com.zhihuishu.athomework.service.Impl;

import com.zhihuishu.athomework.dto.HomeworkFileDto;
import com.zhihuishu.athomework.mapper.cluster.HomeworkFileMapper;
import com.zhihuishu.athomework.service.HomeworkFileService;


public class HomeworkFileServiceImpl  extends BaseService implements HomeworkFileService{

    HomeworkFileMapper homeworkFileMapper;

    @Override
    public Integer getHomeworFileID(Long homeworkId, Long paperId, Long userId, Long exerciseId) {
        Integer result = -1;
        try{

            result=homeworkFileMapper.getHomeworFileID(homeworkId,paperId,userId,exerciseId);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Integer insertHomeworkFile(HomeworkFileDto homeworkFileDto) {
        Integer result = -1;
        try {
            result = homeworkFileMapper.insertHomeworkFile(homeworkFileDto);
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
