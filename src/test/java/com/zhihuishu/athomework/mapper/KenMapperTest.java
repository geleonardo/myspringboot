package com.zhihuishu.athomework.mapper;

import com.zhihuishu.athomework.dto.KenDto;
import com.zhihuishu.athomework.mapper.master.KenMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KenMapperTest {

    @Resource
    private KenMapper kenMapper;

    @Test
    public void testSaveKen(){
        KenDto kenDto1 = new KenDto();
        kenDto1.setTitle("二叉树");
        kenDto1.setCourseId(2L);
        kenDto1.setUserId(4342L);

        KenDto kenDto2 = new KenDto();
        kenDto2.setTitle("图3");
        kenDto2.setCourseId(3L);
        kenDto2.setUserId(42342L);

        kenMapper.saveKen(kenDto1);
        kenMapper.saveKen(kenDto2);
    }
}
