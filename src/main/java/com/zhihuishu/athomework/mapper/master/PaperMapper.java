package com.zhihuishu.athomework.mapper.master;

import com.zhihuishu.athomework.dto.PaperDto;
import com.zhihuishu.athomework.model.Paper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaperMapper {

    //获取试卷信息
    PaperDto getPaperInfo(Long paperId);

    Integer updatePaperDemo(PaperDto paperDto);

    Integer insertPaperDemo(PaperDto paperDto);
}
