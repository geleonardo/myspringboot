package com.zhihuishu.athomework.dto;


import org.junit.Test;

public class QuestionCourseDtoTest {

    @Test
    public void testHashCode() {
        QuestionCourseDto questionCourseDto1 = new QuestionCourseDto();
        questionCourseDto1.setQuestionId(13242222222222222L);
        questionCourseDto1.setCourseId(null);
        questionCourseDto1.setFolderId(422L);
        System.out.println(questionCourseDto1.hashCode());

        QuestionCourseDto questionCourseDto2 = new QuestionCourseDto();
        questionCourseDto2.setQuestionId(null);
        questionCourseDto2.setCourseId(-32424242L);
        questionCourseDto2.setFolderId(-455555555555522L);
        System.out.println(questionCourseDto2.hashCode());

        System.out.println(questionCourseDto1.equals(questionCourseDto2));
    }
}
