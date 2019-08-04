package com.supertrampai.basedemo.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @auther lxh800109@gmail.com
 * @create 2019-08-01 15:46
 */
//以json格式输出
@RestController
//类路径
@RequestMapping("baseDemo")
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
}
/*
* @RestController ： 是@Controller和@ResponseBody注释的组合，简化了控制器的实现。实现的功能为：自动将返回对象序列化为HttpResponse
* @RequestMapping() 可以用在类和方法上面，指定url访问路径
*
* */