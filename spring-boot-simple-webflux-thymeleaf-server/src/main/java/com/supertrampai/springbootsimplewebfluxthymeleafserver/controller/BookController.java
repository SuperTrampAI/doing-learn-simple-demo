package com.supertrampai.springbootsimplewebfluxthymeleafserver.controller;

import com.supertrampai.springbootsimplewebfluxthymeleafserver.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 23:47 2019/8/29
 * @Modified By:
 */
@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @RequestMapping("/")
    public String index(final Model model) {

        // loads 1 and display 1, stream data, data driven mode.
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(bookRepository.findAll(), 1);

        model.addAttribute("books", reactiveDataDrivenMode);

        // classic, wait repository loaded all and display it.
        //model.addAttribute("movies", movieRepository.findAll());

        return "index";

    }

}
