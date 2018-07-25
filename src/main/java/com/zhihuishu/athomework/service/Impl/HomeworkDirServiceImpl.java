package com.zhihuishu.athomework.service.Impl;

import com.zhihuishu.athomework.constant.RedisKey;
import com.zhihuishu.athomework.constant.SedisHomework;
import com.zhihuishu.athomework.constant.SedisHomeworkDirFile;
import com.zhihuishu.athomework.dto.HomeworkDirDto;
import com.zhihuishu.athomework.dto.HomeworkDirFileDto;
import com.zhihuishu.athomework.mapper.master.HomeworkDirMapper;
import com.zhihuishu.athomework.redis.RedisKeyUtil;
import com.zhihuishu.athomework.service.HomeworkDirService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HomeworkDirServiceImpl extends BaseService implements HomeworkDirService {

    @Resource
    private HomeworkDirMapper homeworkDirMapper;

    @Override
    public HomeworkDirDto findHomeworkDir(Long homeworkId) {
        HomeworkDirDto homeworkDirDto = null;
        try {
            String redisKey = RedisKey.generateHomeworkDirKey(homeworkId);
            Map<String, String> stringMap = jedisTemplate.hgetAll(redisKey);
            if (stringMap != null && !stringMap.isEmpty()) {
                homeworkDirDto = getRedis_HomeworkDirModel(stringMap);
            } else {
                homeworkDirDto = homeworkDirMapper.findHomeworkDir(homeworkId);
                setRedis_HomeworkDirModel(homeworkDirDto, redisKey);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return homeworkDirDto;
    }

    @Override
    public HomeworkDirDto findHomeworkDirInfo(Long homeworkId) {
        HomeworkDirDto homeworkDirDto = new HomeworkDirDto();
        try {
            homeworkDirDto=findHomeworkDir(homeworkId);
            List<HomeworkDirFileDto> homeworkDirFileDtos=findHomeworkDirFileList(homeworkId);
            homeworkDirDto.setFileList(homeworkDirFileDtos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return homeworkDirDto;
    }

    @Override
    public List<HomeworkDirFileDto> findHomeworkDirFileList(Long homeworkId){
        List<HomeworkDirFileDto> homeworkDirFileDtos=new ArrayList<HomeworkDirFileDto>();
        try{
            List<String> homeworkFileIds=findHomeworkDirFileIDS(homeworkId);
            if(homeworkFileIds!=null){
                HomeworkDirFileDto homeworkDirFileDto=null;
                for(String homeworkFileId:homeworkFileIds){
                    homeworkDirFileDto=findHomeworkDirFile(Long.valueOf(homeworkFileId));
                    if(homeworkDirFileDto!=null){
                        homeworkDirFileDtos.add(homeworkDirFileDto);
                    }
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return homeworkDirFileDtos;
    }

    @Override
    public List<String> findHomeworkDirFileIDS(Long homeworkId) {
        List<String> homeworkFileIds=null;
        try {
            String redisKey = RedisKey.generateHomeworkDirFileIDSKey(homeworkId);
            homeworkFileIds = jedisTemplate.lrange(redisKey, 0, -1);
            if (!jedisTemplate.exists(redisKey)) {
                homeworkFileIds = homeworkDirMapper.findHomeworkDirFileIDS(homeworkId);
                if (homeworkFileIds != null && !homeworkFileIds.isEmpty()) {
                    jedisTemplate.lpush(redisKey, homeworkFileIds);
                    jedisTemplate.expire(redisKey, RedisKeyUtil.EXPIR_FOR_6_MONTH);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return homeworkFileIds;
    }

    @Override
    public HomeworkDirFileDto findHomeworkDirFile(Long homeworkFileId) {
        HomeworkDirFileDto homeworkDirFileDto = null;
        try {
            String redisKey = RedisKey.generateHomeworkDirFileKey(homeworkFileId);
            Map<String, String> stringMap = jedisTemplate.hgetAll(redisKey);
            if (stringMap != null && !stringMap.isEmpty()) {
                homeworkDirFileDto = getRedis_HomeworkDirFileModel(stringMap);
            } else {
                homeworkDirFileDto = homeworkDirMapper.findHomeworkDirFile(homeworkFileId);
                setRedis_HomeworkDirFileModel(homeworkDirFileDto, redisKey);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return homeworkDirFileDto;
    }

    @Override
    public Boolean insertHomeworkDirQuestion(Long homeworkId,String content,Double score){
        Boolean flag=false;
        try{
            Integer i=homeworkDirMapper.insertHomeworkDirQuestion(homeworkId,content,score);
            if(i==1){
                flag=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    private HomeworkDirDto getRedis_HomeworkDirModel(Map<String, String> stringMap) {
        HomeworkDirDto model = new HomeworkDirDto();
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
        String classIds = stringMap.get(SedisHomework.CLASSIDS);
        String content = stringMap.get(SedisHomework.CONTENT);
        String score = stringMap.get(SedisHomework.SCORE);

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
        if (StringUtils.isNotEmpty(classIds)) {
            model.setClassIds(classIds);
        }
        if (StringUtils.isNotEmpty(content)) {
            model.setContent(content);
        }
        if (StringUtils.isNotEmpty(score)) {
            model.setScore(Double.valueOf(score));
        }
        return model;
    }

    private void setRedis_HomeworkDirModel(HomeworkDirDto model, String redisKey) {
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
            String classIds = model.getClassIds();
            if (classIds != null) {
                map.put(SedisHomework.CLASSIDS, classIds);
            }
            String content = model.getContent();
            if (content != null) {
                map.put(SedisHomework.CONTENT, content);
            }
            Double score = model.getScore();
            if (score != null) {
                map.put(SedisHomework.SCORE, score.toString());
            }
            // 存入缓存
            jedisTemplate.hmset(redisKey, map);
            jedisTemplate.expire(redisKey, RedisKeyUtil.EXPIR_FOR_6_MONTH);
        }
    }

    private HomeworkDirFileDto getRedis_HomeworkDirFileModel(Map<String, String> stringMap) {
        HomeworkDirFileDto model = new HomeworkDirFileDto();
        String id = stringMap.get(SedisHomeworkDirFile.ID);
        String homeworkId = stringMap.get(SedisHomeworkDirFile.HOMEWORKID);
        String fileId = stringMap.get(SedisHomeworkDirFile.FILEID);
        String fileTitle = stringMap.get(SedisHomeworkDirFile.FILETITLE);
        String fileSize = stringMap.get(SedisHomeworkDirFile.FILESIZE);
        String fileUrl = stringMap.get(SedisHomeworkDirFile.FILEURL);
        String uploadTime = stringMap.get(SedisHomeworkDirFile.UPLOADTIME);

        if (StringUtils.isNotEmpty(id)) {
            model.setId(Long.valueOf(id));
        }
        if (StringUtils.isNotEmpty(homeworkId)) {
            model.setHomeworkId(Long.valueOf(homeworkId));
        }
        if (StringUtils.isNotEmpty(fileId)) {
            model.setFileId(Long.valueOf(fileId));
        }
        if (StringUtils.isNotEmpty(fileTitle)) {
            model.setFileTitle(fileTitle);
        }
        if (StringUtils.isNotEmpty(fileSize)) {
            model.setFileSize(Integer.valueOf(fileSize));
        }
        if (StringUtils.isNotEmpty(fileUrl)) {
            model.setFileUrl(fileUrl);
        }
        if (StringUtils.isNotEmpty(uploadTime)) {
            model.setUploadTime(Date.valueOf(uploadTime));
        }
        return model;
    }

    private void setRedis_HomeworkDirFileModel(HomeworkDirFileDto model, String redisKey) {
        if (model != null) {
            Map<String, String> map = new HashMap<String, String>();
            Long id = model.getId();
            if (id != null) {
                map.put(SedisHomework.ID, id.toString());
            }
            Long homeworkId = model.getHomeworkId();
            if (homeworkId != null) {
                map.put(SedisHomeworkDirFile.HOMEWORKID ,homeworkId.toString());
            }
            Long fileId = model.getFileId();
            if (fileId != null) {
                map.put(SedisHomeworkDirFile.FILEID, fileId.toString());
            }
            String fileTitle = model.getFileTitle();
            if (fileTitle != null) {
                map.put(SedisHomeworkDirFile.FILETITLE, fileTitle);
            }
            Integer fileSize = model.getFileSize();
            if (fileSize != null) {
                map.put(SedisHomeworkDirFile.FILESIZE, fileSize.toString());
            }
            String fileUrl = model.getFileUrl();
            if (fileUrl != null) {
                map.put(SedisHomeworkDirFile.FILEURL, fileUrl);
            }
            Date uploadTime = model.getUploadTime();
            if (uploadTime != null) {
                map.put(SedisHomeworkDirFile.UPLOADTIME, uploadTime.toString());
            }
            // 存入缓存
            jedisTemplate.hmset(redisKey, map);
            jedisTemplate.expire(redisKey, RedisKeyUtil.EXPIR_FOR_6_MONTH);
        }
    }
}
