package com.supertrampai.springbootsimplewebfluxthymeleafserver.repository;

import com.supertrampai.springbootsimplewebfluxthymeleafserver.Book;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: LiXiangHong
 * @Email: lxh800109@gmail.com
 * @Description:
 * @Date: Created in 23:48 2019/8/29
 * @Modified By:
 */
@Repository
public class ReactiveBookRepository implements  BookRepository {

    private static List<Book> movie = new ArrayList<>();

    static {
        movie.add(new Book("Polar (2019)", 64));
        movie.add(new Book("Iron Man (2008)", 79));
        movie.add(new Book("The Shawshank Redemption (1994)", 93));
        movie.add(new Book("Forrest Gump (1994)", 83));
        movie.add(new Book("Glass (2019)", 70));
    }

    @Override
    public Flux<Book> findAll() {
        //Simulate big list of data, streaming it every 2 second delay
        return Flux.fromIterable(movie).delayElements(Duration.ofSeconds(2));
    }

}
