package com.zhihuishu.athomework.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class QuestionDto implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id; //试题id

    private Integer questionTypeId; //题型id

    private Integer diff; //难度 1 简单；2 中等；3难

    private String content; //习题的内容

    private String result; //答案

    private Integer from; //来源类别（1、自建，2导入，3其他题库共享）

    private Integer hit; //使用次数

    private Date createTime; //创建时间

    private Boolean isDisplay; //显示状态

    private Long userId; //创建人

    private Long parentId; //组合题大题编号

    private String analysis; //答案解析

    private Integer schoolId; //学校

    private Date updateTime; //修改时间

    private Long lastUpdateUserId; //最后修改人id

    private Boolean isDeleted; //删除状态

    private QuestionTypeDto questionTypeDto; //题型关联

    private List<QuestionOptionDto> questionOptionDtoList; //选项关联

    private List<QuestionCourseDto> questionCourseDtoList; //课程、资源关联

    private List<QuestionFileDto> questionFileDtoList; //文件关联

    private List<QuestionKenDto> questionKenDtoList; //知识点关联

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Integer questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public Integer getDiff() {
        return diff;
    }

    public void setDiff(Integer diff) {
        this.diff = diff;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getDisplay() {
        return isDisplay;
    }

    public void setDisplay(Boolean display) {
        isDisplay = display;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(Long lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public QuestionTypeDto getQuestionTypeDto() {
        return questionTypeDto;
    }

    public void setQuestionTypeDto(QuestionTypeDto questionTypeDto) {
        this.questionTypeDto = questionTypeDto;
    }

    public List<QuestionOptionDto> getQuestionOptionDtoList() {
        return questionOptionDtoList;
    }

    public void setQuestionOptionDtoList(List<QuestionOptionDto> questionOptionDtoList) {
        this.questionOptionDtoList = questionOptionDtoList;
    }

    public List<QuestionCourseDto> getQuestionCourseDtoList() {
        return questionCourseDtoList;
    }

    public void setQuestionCourseDtoList(List<QuestionCourseDto> questionCourseDtoList) {
        this.questionCourseDtoList = questionCourseDtoList;
    }

    public List<QuestionFileDto> getQuestionFileDtoList() {
        return questionFileDtoList;
    }

    public void setQuestionFileDtoList(List<QuestionFileDto> questionFileDtoList) {
        this.questionFileDtoList = questionFileDtoList;
    }

    public List<QuestionKenDto> getQuestionKenDtoList() {
        return questionKenDtoList;
    }

    public void setQuestionKenDtoList(List<QuestionKenDto> questionKenDtoList) {
        this.questionKenDtoList = questionKenDtoList;
    }
}
