package com.zhihuishu.athomework.mapper.master;

import com.zhihuishu.athomework.dto.KenDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KenMapper {

    KenDto findKenById(Long kenId);

    Long getIdByCourseIdAndTitle(@Param("courseId") Long courseId,@Param("title") String title);

    Integer saveKen(KenDto kenDto);

}
