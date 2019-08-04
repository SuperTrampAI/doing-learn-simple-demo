package com.supertrampai.basedemo.repository;

import com.supertrampai.basedemo.domain.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author lxh800109@gmail.com
 * @Description
 * @create 2019/08/02 11:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepositoryTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void test() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        Book book=new Book(12,"bname12",14,"publish12",date,120,123,"content12");

        //bookRepository.save(new Book("bname15",14,"publish12",date,120,123,"content12"));
        //bookRepository.save(new Book("bname16",14,"publish13",date,120,123,"content13"));
        //bookRepository.save(new Book("bname18",14,"publish18",date,120,123,"content18"));

        //Assert.assertEquals(12, bookRepository.findAll().size());
        Assert.assertEquals("bname18", bookRepository.findByBnameAndPrice("bname18", 123).getBname());
        //bookRepository.delete(bookRepository.findByBname("bname12"));
    }

}
