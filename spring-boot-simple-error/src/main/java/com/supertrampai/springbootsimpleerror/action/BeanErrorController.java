package com.supertrampai.springbootsimpleerror.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 18:13 2019/9/1
 * @Modified By:
 */
@Controller
public class BeanErrorController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value="/ex")
    @ResponseBody
    public String error() throws Exception {
        throw new Exception("发生错误");
    }

}