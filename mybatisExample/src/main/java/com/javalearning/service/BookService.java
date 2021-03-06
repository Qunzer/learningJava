package com.javalearning.service;

import com.google.common.base.Supplier;
import com.javalearning.dao.BookDao;
import com.javalearning.model.Book;
import com.javalearning.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by renqun.yuan on 2015/12/8.
 */
public class BookService {
    private static final Supplier<SqlSessionFactory> sqlSessionFactorySupplier = SessionFactoryUtil.getSqlSessionFactory();

    public Book queryBookById(Integer id) {
        SqlSession sqlSession = sqlSessionFactorySupplier.get().openSession();
        try {
            BookDao mapper = sqlSession.getMapper(BookDao.class);
            return mapper.selectBookById(id);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public Integer insertBook(Book book) {
        try (SqlSession sqlSession = sqlSessionFactorySupplier.get().openSession()) {
            BookDao mapper = sqlSession.getMapper(BookDao.class);
            mapper.insertBook(book);
            sqlSession.commit();
            return book.getId();
        }
    }

    public void insertBookBatch(List<Book> books) {
        if (books == null || books.size() == 0) {
            return;
        }

        try (SqlSession sqlSession = sqlSessionFactorySupplier.get().openSession()) {
            BookDao mapper = sqlSession.getMapper(BookDao.class);
            mapper.insertBookBatch(books);
            sqlSession.commit();
        }
    }

    public List<Book> queryBookByCondition(final Book book) {
        Map<String, Object> params = new HashMap<String, Object>() {
            {
                put("author", book.getAuthor());
                put("publishDate", book.getPublishDate());
                put("name", book.getName());
            }
        };

        try (SqlSession sqlSession = sqlSessionFactorySupplier.get().openSession()) {
            BookDao mapper = sqlSession.getMapper(BookDao.class);
            return mapper.selectBookCondition(params);
        }
    }

    public List<Book> queryBookByAuthor(String author) {
        try (SqlSession sqlSession = sqlSessionFactorySupplier.get().openSession()) {
            BookDao mapper = sqlSession.getMapper(BookDao.class);
            return mapper.selectBookByAuthor(author);
        }
    }

    public Integer insertBookWithoutConfigFile(Book book) {
        try (SqlSession sqlSession = sqlSessionFactorySupplier.get().openSession()) {
            BookDao mapper = sqlSession.getMapper(BookDao.class);
            mapper.insertBookWithoutConfigFile(book);
            sqlSession.commit();
            return book.getId();
        }
    }
}
