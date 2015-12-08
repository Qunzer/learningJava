package com.javalearning.service;

import com.javalearning.model.Book;

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
        Book book = bookService.queryBookById(8);
        System.out.println(book);

    }

    @org.junit.Test
    public void testInsertBook() throws Exception {

    }

    @org.junit.Test
    public void testQueryBookByConditon() throws Exception {
        Book book = new Book();
    }

    @org.junit.Test
    public void testQueryBookByAuthor() throws Exception {
        List<Book> books = bookService.queryBookByAuthor("mybatis ge");
        System.out.println(books.size());
    }
}