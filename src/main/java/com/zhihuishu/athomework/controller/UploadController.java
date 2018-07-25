package com.zhihuishu.athomework.controller;

import com.zhihuishu.athomework.utils.Json;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @RequestMapping("/uploadFile")
    public String uploadFile(Map<String, Object> map){

        return "upload";
    }

}
