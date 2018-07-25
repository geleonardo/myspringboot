package com.zhihuishu.athomework.service;

import com.zhihuishu.athomework.dto.HomeworkDirDto;
import com.zhihuishu.athomework.dto.HomeworkDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HomeworkService {

    HomeworkDto findHomeworkInfo(Long homeworkId);

    List<HomeworkDto> findHomeworkList(Long userId, Integer status, Integer pageNum, Integer pageSize);

    Long insertHomework(HomeworkDto homeworkDto);

    Integer updateHomework(HomeworkDto homeworkDto);

    Boolean deleteHomeworkClass(Long homeworkId);

    Long insertHomeworkClass(Long homeworkId, Long classId);

    Boolean allotHomeworkUser(Long homeworkId);

}
