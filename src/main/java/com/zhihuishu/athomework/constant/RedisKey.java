package com.zhihuishu.athomework.constant;


import com.zhihuishu.athomework.redis.RedisKeyUtil;

public class RedisKey {

    //作业  homeworkId 为作业表ID 直接出题
    public  static  String generateHomeworkDirKey(Long homeworkId)
    {
        return RedisKeyUtil.key("at",RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"HomeworkDir",homeworkId);
    }

    //作业  homeworkIFiled 为作业附件表ID 直接出题
    public  static  String generateHomeworkDirFileKey(Long homeworkFileId)
    {
        return RedisKeyUtil.key("at",RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"HomeworkDirFile",homeworkFileId);
    }

    //作业下附件ID集合 homeworkId 为作业表ID
    public  static  String generateHomeworkDirFileIDSKey(Long homeworkId)
    {
        return RedisKeyUtil.key("at",RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"HomeworkDirFileIDS",homeworkId);
    }

    //作业  homeworkId 为作业表ID 题目组卷
    /*********************************************   直接出题   *****************************************************/
    //直接出题学生作业队列 HomeworDirkUser，UserID
    public  static  String generateHomeworDirkUserQueueKey(Long userId)
    {
        return RedisKeyUtil.key("at",RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"HomeworkDirUserQueue",userId);

    }

    //直接出题 学生作业，homeworkId 为作业表ID
    public  static  String generateHomeworDirkUserKey(Long homeworkId)
    {
        return RedisKeyUtil.key("at",RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"HomeworkDirUser",homeworkId);

    }

    //直接出题HomeworkDirAnswer，homeworkId 为作业表ID
    public  static  String generateHomeworkDirAnswerKey(Long homeworkId)
    {
        return RedisKeyUtil.key("at",RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"HomeworkDirAnswer",homeworkId);

    }

    //直接出题HomeworkDirAnswerFile，homeworkId 为作业表ID
    public  static  String generateHomeworkDirAnswerFileKey(Long homeworkId)
    {
        return RedisKeyUtil.key("at",RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"HomeworkDirAnswerFile",homeworkId);
    }



    /*********************************************   直接出题   *****************************************************/

    //作业  homeworkId 为作业表ID
    public  static  String generateHomeworkKey(Long homeworkId)
    {
        return RedisKeyUtil.key("at",RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"Homework",homeworkId);

    }

    //作业试卷关联表  homeworkId和paperId为对应表的ID
    public  static  String generateHomeworkPaperKey(Long homeworkId,Long paperId)
    {
        return RedisKeyUtil.key("at",RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"HomeworkPaperImpl",homeworkId,paperId);

    }

    //试卷表 paperId 为试卷表ID
    public  static  String generatePaperKey(Long paperId)
    {
        return RedisKeyUtil.key("at",RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"Paper",paperId);
    }

    //试卷下分组ID集合 paperId 为试卷表ID
    public  static  String generatePaperGroupIDSKey(Long paperId)
    {
        return RedisKeyUtil.key("at",RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"PaperGroupIDS",paperId);
    }

    //试卷分组表 groupId为分组表ID
    public  static  String generatePaperGroupKey(Long groupId)
    {
        return RedisKeyUtil.key("at",RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"PaperGroup",groupId);
    }

    //分组下习题ID集合 groupId为分组表ID
    public  static  String generatePaperQuestionIDSKey(Long groupId)
    {
        return RedisKeyUtil.key("at",RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"PaperGroupIDS",groupId);
    }

    //试卷分组习题表 paperId 为试卷表ID，groupId为分组表ID，questionId为习题ID
    public  static  String generatePaperQuestionKey(Long paperId,Long groupId,Long questionId)
    {
        return RedisKeyUtil.key("at",RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"PaperQuestionMapper",paperId,groupId,questionId);
    }

   //学生作业答案
    public static  String generateHomeworkAnswerKey(Long homeworkId,Long paperId,Long userId,Long questionId)
    {
        return RedisKeyUtil.key("at", RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"homeworAnswer",homeworkId,paperId,userId,questionId);
    }

    //学生作业
    public static  String generateHomeworkUserKey(Long homeworId,Long paperId,Long userId)
    {
        return RedisKeyUtil.key("at",RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"homeworUser",homeworId,paperId,userId);
    }

    //学生作业附件
    public static  String generateHomeworkFileKey(Long homeworkId,Long paperId,Long userId,Long exerciseId)
    {
        return RedisKeyUtil.key("at",RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"HomeworkFile",homeworkId,paperId,userId,exerciseId);
    }

    //学生作业答案队列
    public static  String generateHomeworkAnswerQueueKey()
    {
        return RedisKeyUtil.key("at",RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"HomeworkAnswerQueue");

    }

    //学生作业队列
    public static  String generateHomeworkUserQueueKey()
    {
        return RedisKeyUtil.key("at",RedisKeyUtil.HOMEWORK_EXAM_PREFIX,"HomeworkUserQueue");

    }

    /*=========== 题库相关缓存start =============*/

    //习题基本信息
    public static String generateQuestionKey(Long questionId){
        return RedisKeyUtil.key("at", RedisKeyUtil.HOMEWORK_EXAM_PREFIX, "question", questionId);
    }

    //习题附件表
    public static String generateQuestionFileKey(Long questionId) {
        return RedisKeyUtil.key("at", RedisKeyUtil.HOMEWORK_EXAM_PREFIX, "quesfile", questionId);
    }

    //习题选项表
    public static String generateQuestionOptionKey(Long questionId) {
        return RedisKeyUtil.key("at", RedisKeyUtil.HOMEWORK_EXAM_PREFIX, "quesoption", questionId);
    }

    /*=========== 题库相关缓存end ===============*/

}
