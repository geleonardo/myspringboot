package com.zhihuishu.athomework.service;


public interface CourseService {

    /**
     * @Description 获取教师下的所有课程
     * @author lvxiangjun
     * @param
     * @date 2018-7-19 08:55:05
     */
    void getAllCourseByUserId();

    /**
     * @Description 获取课程下的所有资源
     * @author lvxiangjun
     * @param
     * @date 2018-7-19 08:55:05
     */
    void getAllFileByCourseId();
}
