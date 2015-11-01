package com.javalearning.elasticsearchtest;

import com.google.common.collect.Lists;
import com.javalearning.elasticsearchexample.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by renqun.yuan on 2015/11/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/elasticsearch-config.xml")
public class ElasticSearchTemplateTest {
    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Before
    public void before() {

    }

    @Test
    public void saveTest() {
        Book book = new Book();
        book.setId("56");
        book.setAuthors(Lists.newArrayList("ray", "yrq"));
        book.setName("el_template33");
        book.setPrice((double) 10);
        book.setPublishDate(new Date());
        IndexQueryBuilder indexQueryBuilder = new IndexQueryBuilder();
        indexQueryBuilder.withObject(book).withId(book.getId());
        String documentId = elasticsearchTemplate.index(indexQueryBuilder.build());
        System.out.println(documentId);
    }

    @Test
    public void queryTest() {
        CriteriaQuery criteriaQuery = new CriteriaQuery(null);
        Criteria criteria = Criteria.where("id").is("1");
        criteriaQuery.addCriteria(criteria);
        Book book = elasticsearchTemplate.queryForObject(criteriaQuery, Book.class);
        System.out.println(book);
    }
}
