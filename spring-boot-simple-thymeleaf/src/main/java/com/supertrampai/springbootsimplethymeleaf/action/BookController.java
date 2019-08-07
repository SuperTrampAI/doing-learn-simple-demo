package com.supertrampai.springbootsimplethymeleaf.action;

import com.supertrampai.springbootsimplethymeleaf.domain.Book;
import com.supertrampai.springbootsimplethymeleaf.repository.BookRepository;
import com.supertrampai.springbootsimplethymeleaf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/01 20:50
 */
@Controller
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/signup")
    public String showSignUpForm(Book book) {
        return "add-book";
    }

    @PostMapping("/addbook")
    public String addBook(@Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-book";
        }

        bookService.saveBook(book);
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{bid}")
    public String showUpdateForm(@PathVariable("bid") Integer bid, Model model) {
        Book book = bookRepository.findById(bid)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book bid:" + bid));

        model.addAttribute("book", book);
        return "update-book";
    }

    @PostMapping("/update/{bid}")
    public String updateBook(@PathVariable("bid") Integer bid, @Valid Book book,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            book.setBid(bid);
            return "update-book";
        }
        bookRepository.save(book);
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{bid}")
    public String deleteBook(@PathVariable("bid") Integer bid, Model model) {
        Book book = bookRepository.findById(bid)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book bid:" + bid));
        bookRepository.delete(book);
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

}
