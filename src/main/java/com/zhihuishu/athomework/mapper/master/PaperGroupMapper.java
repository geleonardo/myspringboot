package com.zhihuishu.athomework.mapper.master;

import com.zhihuishu.athomework.dto.PaperGroupDto;
import com.zhihuishu.athomework.model.PaperGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaperGroupMapper {

        PaperGroupDto findPaperGroupInfo(@Param("groupId") Long groupId);

        List<String> findPaperGroupIDS(@Param("paperId") Long paperId);

}
