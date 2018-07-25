package com.zhihuishu.athomework.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhihuishu.athomework.constant.RedisKey;
import com.zhihuishu.athomework.constant.SedisHomework;
import com.zhihuishu.athomework.dto.HomeworkDirDto;
import com.zhihuishu.athomework.dto.HomeworkDirFileDto;
import com.zhihuishu.athomework.dto.HomeworkDto;
import com.zhihuishu.athomework.mapper.master.HomeworkMapper;
import com.zhihuishu.athomework.redis.RedisKeyUtil;
import com.zhihuishu.athomework.service.HomeworkService;
import com.zhihuishu.athomework.service.HomeworkUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomeworkServiceImpl extends BaseService implements HomeworkService {

    @Resource
    private HomeworkMapper homeworkMapper;

    @Resource
    private HomeworkUserService homeworkUserService;

    @Override
    public List<HomeworkDto> findHomeworkList(Long userId, Integer status, Integer pageNum, Integer pageSize) {
        List<HomeworkDto> homeworkDtoList = null;
        try {
            PageHelper.startPage(pageNum, pageSize);
            homeworkDtoList = homeworkMapper.findHomeworkList(userId, status);
            System.out.println(((Page) homeworkDtoList).getTotal());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return homeworkDtoList;
    }

    @Override
    public HomeworkDto findHomeworkInfo(Long homeworkId) {
        HomeworkDto homeworkDto = null;
        try {
            String redisKey = RedisKey.generateHomeworkKey(homeworkId);
            Map<String, String> stringMap = jedisTemplate.hgetAll(redisKey);
            if (stringMap != null && !stringMap.isEmpty()) {
                homeworkDto = getRedis_HomeworkModel(stringMap);
            } else {
                homeworkDto = homeworkMapper.findHomeworkInfo(homeworkId);
                setRedis_HomeworkModel(homeworkDto, redisKey);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return homeworkDto;
    }

    @Override
    public Long insertHomework(HomeworkDto homeworkDto) {
        Long homeworkId = null;
        try {
            homeworkId = homeworkMapper.insertHomework(homeworkDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return homeworkId;
    }

    @Override
    public Integer updateHomework(HomeworkDto homeworkDto) {
        Integer id = null;
        try {
            id = homeworkMapper.updateHomework(homeworkDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public Boolean deleteHomeworkClass(Long homeworkId) {
        Boolean flag = false;
        try {
            homeworkMapper.deleteHomeworkClass(homeworkId);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Long insertHomeworkClass(Long homeworkId, Long classId) {
        Long id = null;
        try {
            id = homeworkMapper.insertHomeworkClass(homeworkId, classId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    //分配学生作业
    @Override
    public Boolean allotHomeworkUser(Long homeworkId) {
        Long paperId = null;
        Long userId = null;
        Boolean result = homeworkUserService.insertHomeworkUser(userId, homeworkId, paperId);

        return result;
    }



    private HomeworkDto getRedis_HomeworkModel(Map<String, String> stringMap) {
        HomeworkDto model = new HomeworkDto();
        String id = stringMap.get(SedisHomework.ID);
        String courseId = stringMap.get(SedisHomework.COURSEID);
        String title = stringMap.get(SedisHomework.TITLE);
        String endTime = stringMap.get(SedisHomework.ENDTIME);
        String buildMode = stringMap.get(SedisHomework.BUILDMODE);
        String folderId = stringMap.get(SedisHomework.FOLDERID);
        String submitOption = stringMap.get(SedisHomework.SUBMITOPTION);
        String isPublish = stringMap.get(SedisHomework.ISPUBLISH);
        String showScore = stringMap.get(SedisHomework.SHOWSCORE);
        String isDelay = stringMap.get(SedisHomework.ISDELAY);
        String randMode = stringMap.get(SedisHomework.RANDMODE);
        String createUserId = stringMap.get(SedisHomework.CREATEUSERID);
        String createTime = stringMap.get(SedisHomework.CREATETIME);
        String updateTime = stringMap.get(SedisHomework.UPDATETIME);
        String schoolId = stringMap.get(SedisHomework.SCHOOLID);

        if (StringUtils.isNotEmpty(id)) {
            model.setId(Long.valueOf(id));
        }
        if (StringUtils.isNotEmpty(courseId)) {
            model.setCourseId(Long.valueOf(courseId));
        }
        if (StringUtils.isNotEmpty(title)) {
            model.setTitle(title);
        }
        if (StringUtils.isNotEmpty(endTime)) {
            model.setEndTime(Date.valueOf(endTime));
        }
        if (StringUtils.isNotEmpty(buildMode)) {
            model.setBuildMode(Integer.valueOf(buildMode));
        }
        if (StringUtils.isNotEmpty(folderId)) {
            model.setFolderId(Integer.valueOf(folderId));
        }
        if (StringUtils.isNotEmpty(submitOption)) {
            model.setSubmitOption(Integer.valueOf(submitOption));
        }
        if (StringUtils.isNotEmpty(isPublish)) {
            model.setIsPublish(Integer.valueOf(isPublish));
        }
        if (StringUtils.isNotEmpty(showScore)) {
            model.setShowScore(Integer.valueOf(showScore));
        }
        if (StringUtils.isNotEmpty(isDelay)) {
            model.setIsDelay(Integer.valueOf(isDelay));
        }
        if (StringUtils.isNotEmpty(randMode)) {
            model.setRandMode(Integer.valueOf(randMode));
        }
        if (StringUtils.isNotEmpty(createUserId)) {
            model.setCreateUserId(Long.valueOf(createUserId));
        }
        if (StringUtils.isNotEmpty(createTime)) {
            model.setCreateTime(Date.valueOf(createTime));
        }
        if (StringUtils.isNotEmpty(updateTime)) {
            model.setUpdateTime(Date.valueOf(updateTime));
        }
        if (StringUtils.isNotEmpty(schoolId)) {
            model.setSchoolId(Integer.valueOf(schoolId));
        }
        return model;
    }

    private void setRedis_HomeworkModel(HomeworkDto model, String redisKey) {
        if (model != null) {
            Map<String, String> map = new HashMap<String, String>();
            Long id = model.getId();
            if (id != null) {
                map.put(SedisHomework.ID, id.toString());
            }
            Long courseId = model.getCourseId();
            if (courseId != null) {
                map.put(SedisHomework.COURSEID, courseId.toString());
            }
            String title = model.getTitle();
            if (title != null) {
                map.put(SedisHomework.TITLE, title);
            }
            Date endTime = model.getEndTime();
            if (courseId != null) {
                map.put(SedisHomework.ENDTIME, endTime.toString());
            }
            Integer buildMode = model.getBuildMode();
            if (buildMode != null) {
                map.put(SedisHomework.BUILDMODE, buildMode.toString());
            }
            Integer folderId = model.getFolderId();
            if (folderId != null) {
                map.put(SedisHomework.FOLDERID, folderId.toString());
            }
            Integer submitOption = model.getSubmitOption();
            if (submitOption != null) {
                map.put(SedisHomework.SUBMITOPTION, submitOption.toString());
            }
            Integer isPublish = model.getIsPublish();
            if (isPublish != null) {
                map.put(SedisHomework.ISPUBLISH, isPublish.toString());
            }
            Integer showScore = model.getShowScore();
            if (showScore != null) {
                map.put(SedisHomework.SHOWSCORE, showScore.toString());
            }
            Integer isDelay = model.getIsDelay();
            if (isDelay != null) {
                map.put(SedisHomework.ISDELAY, isDelay.toString());
            }
            Integer randMode = model.getRandMode();
            if (randMode != null) {
                map.put(SedisHomework.RANDMODE, randMode.toString());
            }
            Long createUserId = model.getCreateUserId();
            if (createUserId != null) {
                map.put(SedisHomework.CREATEUSERID, createUserId.toString());
            }
            Date createTime = model.getCreateTime();
            if (createTime != null) {
                map.put(SedisHomework.CREATETIME, createTime.toString());
            }
            Date updateTime = model.getUpdateTime();
            if (updateTime != null) {
                map.put(SedisHomework.UPDATETIME, updateTime.toString());
            }
            Integer schoolId = model.getSchoolId();
            if (schoolId != null) {
                map.put(SedisHomework.SCHOOLID, schoolId.toString());
            }
            // 存入缓存
            jedisTemplate.hmset(redisKey, map);
            jedisTemplate.expire(redisKey, RedisKeyUtil.EXPIR_FOR_6_MONTH);
        }
    }
}
