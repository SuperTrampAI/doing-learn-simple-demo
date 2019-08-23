package com.supertrampai.springbootsimpleen_cn.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/23 19:37
 */
@Controller
public class IndexController {

    @Autowired
    private MessageSource messageSource;


    @RequestMapping("/")
    public String hello(Model model){
        Locale locale = LocaleContextHolder.getLocale();
        model.addAttribute("message", messageSource.getMessage("message", null, locale));
        return "index";
    }
}