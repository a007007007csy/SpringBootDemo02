package com.springboot.demo10elasticsearch.repository;

import com.springboot.demo10elasticsearch.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

    //public List<Book> FindByBookNameLike(String bookName);
}
