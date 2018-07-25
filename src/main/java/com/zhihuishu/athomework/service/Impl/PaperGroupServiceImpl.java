package com.zhihuishu.athomework.service.Impl;

import com.zhihuishu.athomework.constant.RedisKey;
import com.zhihuishu.athomework.constant.SedisPaperGroup;
import com.zhihuishu.athomework.dto.PaperGroupDto;
import com.zhihuishu.athomework.mapper.master.PaperGroupMapper;
import com.zhihuishu.athomework.model.PaperGroup;
import com.zhihuishu.athomework.redis.RedisKeyUtil;
import com.zhihuishu.athomework.service.PaperGroupService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaperGroupServiceImpl extends BaseService implements PaperGroupService {

    @Resource
    private PaperGroupMapper paperGroupMapper;

    @Override
    public PaperGroupDto findPaperGroupInfo( Long groupId) {
        PaperGroupDto paperGroupDto = null;
        try {
            String redisKey = RedisKey.generatePaperGroupKey(groupId);
            Map<String, String> paperGroupMap = jedisTemplate.hgetAll(redisKey);
            if (paperGroupMap != null && !paperGroupMap.isEmpty()) {
                paperGroupDto = getRedis_PaperGroupModel(paperGroupMap);
            } else {
                paperGroupDto = paperGroupMapper.findPaperGroupInfo(groupId);
                setRedis_PaperGroupModel(paperGroupDto, redisKey);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paperGroupDto;
    }

    @Override
    public List<String> findPaperGroupIDS(Long paperId) {
        List<String> groupIds = null;
        try {
            String redisKey = RedisKey.generatePaperGroupIDSKey(paperId);
            groupIds = jedisTemplate.lrange(redisKey, 0, -1);
            if (!jedisTemplate.exists(redisKey)) {
                groupIds = paperGroupMapper.findPaperGroupIDS(paperId);
                if (groupIds != null && !groupIds.isEmpty()) {
                    jedisTemplate.lpush(redisKey, groupIds);
                    jedisTemplate.expire(redisKey, RedisKeyUtil.EXPIR_FOR_6_MONTH);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groupIds;
    }

    private PaperGroupDto getRedis_PaperGroupModel(Map<String, String> stringMap) {
        PaperGroupDto model = new PaperGroupDto();
        String id = stringMap.get(SedisPaperGroup.PAPERGROUP_ID);
        String paperId = stringMap.get(SedisPaperGroup.PAPERGROUP_PAPERID);
        String title = stringMap.get(SedisPaperGroup.PAPERGROUP_TITLE);
        String brief = stringMap.get(SedisPaperGroup.PAPERGROUP_BRIEF);
        String sort = stringMap.get(SedisPaperGroup.PAPERGROUP_SORT);

        if (StringUtils.isNotEmpty(id)) {
            model.setId(Long.valueOf(id));
        }
        if (StringUtils.isNotEmpty(paperId)) {
            model.setPaperId(Long.valueOf(paperId));
        }
        if (StringUtils.isNotEmpty(title)) {
            model.setTitle(title);
        }
        if (StringUtils.isNotEmpty(brief)) {
            model.setBrief(brief);
        }
        if (StringUtils.isNotEmpty(sort)) {
            model.setSort(Integer.valueOf(sort));
        }
        return model;
    }

    private void setRedis_PaperGroupModel(PaperGroupDto model, String redisKey) {
        if (model != null) {
            Map<String, String> map = new HashMap<String, String>();
            Long id = model.getId();
            if (id != null) {
                map.put(SedisPaperGroup.PAPERGROUP_ID, id.toString());
            }
            Long paperId = model.getPaperId();
            if (paperId != null) {
                map.put(SedisPaperGroup.PAPERGROUP_PAPERID, paperId.toString());
            }
            String title = model.getTitle();
            if (title != null) {
                map.put(SedisPaperGroup.PAPERGROUP_TITLE, title);
            }
            String brief = model.getBrief();
            if (brief != null) {
                map.put(SedisPaperGroup.PAPERGROUP_BRIEF, brief);
            }
            Integer sort = model.getSort();
            if (sort != null) {
                map.put(SedisPaperGroup.PAPERGROUP_SORT, sort.toString());
            }
            // 存入缓存
            jedisTemplate.hmset(redisKey, map);
            jedisTemplate.expire(redisKey, RedisKeyUtil.EXPIR_FOR_6_MONTH);
        }
    }
}
