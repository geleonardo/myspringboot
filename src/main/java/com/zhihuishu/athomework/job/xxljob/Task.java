package com.zhihuishu.athomework.job.xxljob;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

import static com.xxl.job.core.biz.model.ReturnT.SUCCESS_CODE;

@Component
@JobHandler(value="helloWorld")
public class Task extends IJobHandler {
    @Override
    public ReturnT<String> execute(String s){
        System.out.println("毒瘤");
        System.out.println(s);
        ReturnT<String> result2 = new ReturnT<>(SUCCESS_CODE,"张晓飞日了狗");
        return result2;
    }

}
