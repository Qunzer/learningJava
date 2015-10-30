package com.javalearning.elasticsearchtest;

import com.google.common.collect.Lists;
import com.javalearning.elasticsearchexample.model.Book;
import com.javalearning.elasticsearchexample.repositories.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by renqun.yuan on 2015/10/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/elasticsearch-config.xml")
public class BookRepositoryTest {
    @Resource
    private BookRepository bookRepository;
    @Before
    public void init() {
        bookRepository.deleteAll();
    }

    @Test
    public void saveBook() {
        Book book = new Book();
        book.setId("1");
        book.setAuthors(Lists.newArrayList("ray", "yrq"));
        book.setName("中国");
        book.setPrice((double) 10);
        book.setPublishDate(new Date());

        Book book1 = new Book();
        book1.setId("2");
        book1.setAuthors(Lists.newArrayList("ray", "yrq"));
        book1.setName("java");
        book1.setPrice((double) 11);
        book1.setPublishDate(new Date());

        bookRepository.save(book);
        bookRepository.save(book1);
        System.out.println(book);
        Book findBook = bookRepository.findOne(book.getId());
        System.out.println(findBook);
        Page<Book> findByName = bookRepository.findByName("java", new PageRequest(0, 5));
        List<Book> content = findByName.getContent();
        System.out.println(content.size());
    }
}
