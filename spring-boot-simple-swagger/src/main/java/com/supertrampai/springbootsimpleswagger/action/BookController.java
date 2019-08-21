package com.supertrampai.springbootsimpleswagger.action;

import com.supertrampai.springbootsimpleswagger.domain.Book;
import com.supertrampai.springbootsimpleswagger.repository.BookRepository;
import com.supertrampai.springbootsimpleswagger.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/21 19:59
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;


    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/list", method= RequestMethod.GET)
    public Iterable list(Model model){
        Iterable productList = bookRepository.findAll();
        return productList;
    }

    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET)
    public Book showBook(@PathVariable Integer id, Model model){
        Book book = bookRepository.getOne(id);
        return book;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity saveProduct(@RequestBody Book book){
        bookRepository.save(book);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }
    /*@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Book book){
        Book books = bookRepository.getOne(id);
        book.setDescription(product.getDescription());
        book.setImageUrl(product.getImageUrl());
        book.setPrice(product.getPrice());
        bookService.saveBook(books);
        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
    }
*/
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Integer id){
        bookRepository.deleteById(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }
}