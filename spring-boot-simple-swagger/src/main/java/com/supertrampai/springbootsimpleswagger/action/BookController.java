package com.supertrampai.springbootsimpleswagger.action;

import com.supertrampai.springbootsimpleswagger.domain.Book;
import com.supertrampai.springbootsimpleswagger.repository.BookRepository;
import com.supertrampai.springbootsimpleswagger.service.BookService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/21 19:59
 */
@RestController
@RequestMapping("/book")
@Api(value="Employee Management System", description="Operations pertaining to employee in Employee Management System")
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
    public ResponseEntity saveProduct(@Valid @RequestBody Book book){
        bookRepository.save(book);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateBook(@PathVariable Integer id, @Valid @RequestBody Book book){
        Book books = bookRepository.getOne(id);
        books.setBname(book.getBname());
        books.setPublish(book.getPublish());
        books.setPublishdate(book.getPublishdate());
        books.setPrice(book.getPrice());
        books.setPage(book.getPage());
        books.setContent(book.getContent());
        bookRepository.save(book);
        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Integer id){
        bookRepository.deleteById(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }

    /**
     * 指定方法的返回备注以及返回类型
     * @return
     */
    @ApiOperation(value = "View a list of available book", response = List.class)
    @GetMapping("/newlist")
    public List< Book > getAllBooks() {
        return bookRepository.findAll();
    }

    @ApiOperation(value = "View a list of available book", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/newlist1")
    public List < Book > getAllListNew() {
        return bookRepository.findAll();
    }

    @ApiOperation(value = "Add an book")
    @GetMapping("/newlist2")
    public ResponseEntity getAllListNew1(
                @ApiParam(value = "Employee object store in database table", required = true)@Valid @RequestBody Book book) {
        bookRepository.save(book);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }

    // rest风格的路径有两种：
    // 1.list/show/update/delete
    // 2.book/{id} 使用 RequestMethod.GET/POST/PUT/DELETE区分

    //  http://localhost:8080/v2/api-docs

}