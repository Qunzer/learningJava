package com.javalearning.elasticsearchexample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;


/**
 * Created by renqun.yuan on 2015/10/30.
 */
@Document(indexName = "lab", type = "book", shards = 2, replicas = 1)
public class Book {
    @Id
    private String id;
    @Field(type = FieldType.String, index = FieldIndex.not_analyzed)
    private String name;
    private Double price;
    private List<String> authors;
    private Date publishDate;

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", authors=" + authors +
                ", publishDate=" + publishDate +
                '}';
    }
}
