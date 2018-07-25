package com.zhihuishu.athomework.controller;

import com.zhihuishu.athomework.dto.HomeworkDto;
import com.zhihuishu.athomework.service.HomeworkService;
import com.zhihuishu.athomework.utils.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/homework")
public class HomeworkController {

    @Resource
    private HomeworkService homeworkService;

    @RequestMapping("/homework")
    public String toHomework() {
        return "homework";
    }

    @ResponseBody
    @RequestMapping("/findHomeworkList")
    public Json findHomeworkList(Long userId, Integer status, Integer pageNum, Integer pageSize) {
        Json json = new Json();
        try {
            List<HomeworkDto> homeworkDtoList = homeworkService.findHomeworkList(userId, status, pageNum, pageSize);
            json.setSuccessValue(homeworkDtoList);
        } catch (Exception e) {
            json.setExceptionValue(e);
        }
        return json;
    }

    @ResponseBody
    @RequestMapping("/editHomework")
    public Json editHomework(
            @RequestParam("homeworkId") Long homeworkId,
            @RequestParam("courseId") Long courseId,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("endTime") Date endTime,
            @RequestParam("buildMode") Integer buildMode,
            @RequestParam("folderId") Integer folderId,
            @RequestParam("submitOption") Integer submitOption,
            @RequestParam("isPublish") Integer isPublish,
            @RequestParam("isDelay") Integer isDelay,
            @RequestParam("randMode") Integer randMode,
            @RequestParam("schoolId") Integer schoolId,
            @RequestParam("classIds") String classIds,
            @RequestParam("score") BigDecimal score
    ) {
        Json json = new Json();
        Boolean isSuccess = false;
        try {
            HomeworkDto homeworkDto = new HomeworkDto();
            homeworkDto.setId(homeworkId);
            homeworkDto.setCourseId(courseId);
            homeworkDto.setTitle(title);
            homeworkDto.setEndTime(endTime);
            homeworkDto.setBuildMode(buildMode);
            homeworkDto.setFolderId(folderId);
            homeworkDto.setSubmitOption(submitOption);
            homeworkDto.setIsPublish(isPublish);
            homeworkDto.setIsDelay(isDelay);
            homeworkDto.setRandMode(randMode);
            homeworkDto.setSchoolId(schoolId);
            if (homeworkId == 0) {
                homeworkId = homeworkService.insertHomework(homeworkDto);
                if (homeworkId > 0) {
                    isSuccess = true;
                }
            } else {
                int id = homeworkService.updateHomework(homeworkDto);
                if (id == 1) {
                    isSuccess = true;
                }
            }
            if (isSuccess) {
                homeworkService.deleteHomeworkClass(homeworkId);
                String[] ids = classIds.split(",");
                for (String classId : ids) {
                        Long id=homeworkService.insertHomeworkClass(homeworkId,Long.valueOf(classId));
                }
            }
            if(isPublish==1){

            }
            json.setSuccessValue(isSuccess);
        } catch (Exception e) {
            json.setExceptionValue(e);
        }
        return json;
    }
}
