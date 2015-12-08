package com.javalearning.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by renqun.yuan on 2015/12/8.
 */
public class Book {
    /**
     * PRIMARY KEY
     */
    private Integer id;
    /**
     * book name
     */
    private String name;
    /**
     * ISBN No.
     */
    private String isbnNo;
    /**
     * book author
     */
    private String author;
    /**
     * price
     */
    private BigDecimal price;
    /**
     * publish date
     */
    private Date publishDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbnNo() {
        return isbnNo;
    }

    public void setIsbnNo(String isbnNo) {
        this.isbnNo = isbnNo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isbnNo='" + isbnNo + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                '}';
    }
}
