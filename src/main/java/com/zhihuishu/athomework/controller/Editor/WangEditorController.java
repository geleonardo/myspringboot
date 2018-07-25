package com.zhihuishu.athomework.controller.Editor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WangEditorController {

    @RequestMapping("editor/weditor")
    public String weditor()
    {
        return "editor/weditor";
    }

}
