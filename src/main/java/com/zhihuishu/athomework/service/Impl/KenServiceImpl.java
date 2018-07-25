package com.zhihuishu.athomework.service.Impl;

import com.zhihuishu.athomework.dto.KenDto;
import com.zhihuishu.athomework.mapper.master.KenMapper;
import com.zhihuishu.athomework.service.KenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class KenServiceImpl extends BaseService implements KenService{

    @Resource
    private KenMapper kenMapper;

    @Override
    public KenDto findKenById(Long kenId) {
        KenDto kenDto = null;
        try {
            kenDto = kenMapper.findKenById(kenId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kenDto;
    }

    @Override
    public Long getIdByCourseIdAndTitle(Long courseId, String title) {
        Long kenId = null;
        try {
            kenId = kenMapper.getIdByCourseIdAndTitle(courseId, title);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kenId;
    }

    @Override
    public Integer saveKen(KenDto kenDto) {
        Integer result = -1;
        try {
            result = kenMapper.saveKen(kenDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
