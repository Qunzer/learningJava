package com.javalearning.elasticsearchexample.repositories;

import com.javalearning.elasticsearchexample.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by renqun.yuan on 2015/10/30.
 */
public interface BookRepository extends ElasticsearchRepository<Book, String> {
    Page<Book> findByName(String name, Pageable pageable);
}
