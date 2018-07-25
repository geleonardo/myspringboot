package com.zhihuishu.athomework.service.Impl;

import com.zhihuishu.athomework.mapper.master.HomeworkPaperMapper;
import com.zhihuishu.athomework.service.HomeworkPaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HomeworkPaperServiceImpl extends  BaseService implements HomeworkPaperService {

    @Resource
    private HomeworkPaperMapper homeworkPaperMapper;

    @Override
    public Long findPaperID(Long homeworkId) {
        Long paperId = null;
        try {
            paperId = homeworkPaperMapper.findPaperID(homeworkId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paperId;
    }

}
