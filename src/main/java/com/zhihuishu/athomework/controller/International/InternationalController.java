package com.zhihuishu.athomework.controller.International;

import com.zhihuishu.athomework.utils.LocaleMessageSourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@RequestMapping("/inter")
public class InternationalController {

    @Autowired
    private LocaleMessageSourceUtil messageSourceUtil;

    @RequestMapping("/test")
    public String setHomeworkAnswer(HttpServletRequest request, HttpServletResponse response,Model model,String lang){
        System.out.println(lang);
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if("zh".equals(lang)){
            localeResolver.setLocale(request, response, new Locale("zh", "CN"));
        }else if("en".equals(lang)){
            localeResolver.setLocale(request, response, new Locale("en", "US"));
        }
        String welcome = messageSourceUtil.getMessage("welcome");
        model.addAttribute("welcome",welcome);
        System.out.println(welcome);
        return "/inter/test";
    }

}
