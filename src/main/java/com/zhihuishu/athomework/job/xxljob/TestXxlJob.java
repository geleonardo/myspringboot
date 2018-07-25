package com.zhihuishu.athomework.job.xxljob;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

@Component
@JobHandler(value = "myXxlJob")
public class TestXxlJob  extends IJobHandler {

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        System.out.println("执行xxljob");
        ReturnT<String> returnT = new ReturnT<>(ReturnT.SUCCESS_CODE, "执行成功");
        return returnT;
    }

}
