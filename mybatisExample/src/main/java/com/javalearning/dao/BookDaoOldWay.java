package com.javalearning.dao;

import com.javalearning.model.Book;
import com.javalearning.util.SessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by renqun.yuan on 2015/12/12.
 */
public class BookDaoOldWay {

    private SqlSessionFactory sqlSessionFactory = SessionFactoryUtil.getSqlSessionFactory().get();

    public Book queryBookById(Integer id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Book book = sqlSession.selectOne("com.javalearning.dao.BookDao.selectBookById", id);
            return book;
        }
    }
}
