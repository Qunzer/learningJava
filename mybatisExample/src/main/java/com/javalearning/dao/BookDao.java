package com.javalearning.dao;

import com.javalearning.model.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by renqun.yuan on 2015/12/8.
 */
public interface BookDao {
    Integer insertBook(Book book);

    Book selectBookById(Integer id);

    List<Book> selectBookByAuthor(String author);

    List<Book> selectBookCondition(Map<String, Object> params);

    void insertBookBatch(@Param("books") List<Book> books);

    String insert = "insert into book (name,isbn_no,price,author,publish_date) VALUES(#{name},#{isbnNo},#{price},#{author}, #{publishDate})";

    @Insert(insert)
    @Options(useGeneratedKeys = true)
    Integer insertBookWithoutConfigFile(Book book);
}
