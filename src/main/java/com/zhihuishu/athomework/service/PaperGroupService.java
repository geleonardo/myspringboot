package com.zhihuishu.athomework.service;

import com.zhihuishu.athomework.dto.PaperGroupDto;
import com.zhihuishu.athomework.model.PaperGroup;

import java.util.List;

public interface PaperGroupService {

    PaperGroupDto findPaperGroupInfo(Long groupId);

    List<String > findPaperGroupIDS(Long paperId);

}
