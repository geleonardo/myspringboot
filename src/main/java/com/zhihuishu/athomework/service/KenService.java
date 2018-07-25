package com.zhihuishu.athomework.service;

import com.zhihuishu.athomework.dto.KenDto;

public interface KenService {

    KenDto findKenById(Long kenId);

    Long getIdByCourseIdAndTitle(Long courseId, String title);

    Integer saveKen(KenDto kenDto);
}
