package com.javalearning.service;

import com.google.common.collect.Lists;
import com.javalearning.model.Book;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by renqun.yuan on 2015/12/8.
 */
public class BookServiceTest {

    private static BookService bookService;

    @org.junit.Before
    public void setUp() throws Exception {
        bookService = new BookService();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        bookService = null;
    }

    @org.junit.Test
    public void testQueryBookById() throws Exception {
        Book book = bookService.queryBookById(12);
        System.out.println(book);
    }

    @org.junit.Test
    public void testInsertBook() throws Exception {
        Book book = new Book();
        book.setPrice(new BigDecimal(40.50));
        book.setPublishDate(new Date());
        book.setIsbnNo("9787540467777");
        book.setName("花千骨");
        book.setAuthor("果果");
        bookService.insertBook(book);
    }

    @org.junit.Test
    public void testQueryBookByCondition() throws Exception {
        Book book = new Book();
        book.setAuthor("果果");
        book.setName("花千骨");
        List<Book> books = bookService.queryBookByCondition(book);
        System.out.println(books.size());
    }

    @org.junit.Test
    public void testQueryBookByAuthor() throws Exception {
        Book book = new Book();
        book.setPrice(new BigDecimal(83.21));
        book.setPublishDate(new Date());
        book.setIsbnNo("9787540458027");
        book.setName("从你的全世界路过：让所有人心动的故事");
        book.setAuthor("张嘉佳");
        bookService.insertBook(book);
        List<Book> books = bookService.queryBookByAuthor("张嘉佳");
        System.out.println(books.get(0));
        Assert.assertEquals(1, books.size());
        Assert.assertEquals("9787540458027", books.get(0).getIsbnNo());
    }

    @Test
    public void testInsertBookBatch() {
        List<Book> books = Lists.newArrayList();
        Book book = new Book();
        book.setPrice(new BigDecimal(49.00));
        book.setPublishDate(new Date());
        book.setIsbnNo("11796459");
        book.setName("一个人的朝圣");
        book.setAuthor("蕾秋·乔伊斯Rachel Joyce");
        books.add(book);

        Book book1 = new Book();
        book1.setPrice(new BigDecimal(29.80));
        book1.setPublishDate(new Date());
        book1.setIsbnNo("9787535767134");
        book1.setName("复杂");
        book1.setAuthor("梅拉妮·米歇尔");
        books.add(book1);

        bookService.insertBookBatch(books);
    }
}