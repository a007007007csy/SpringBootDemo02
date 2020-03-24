package com.springboot.demo10elasticsearch;

import com.springboot.demo10elasticsearch.bean.Article;
import com.springboot.demo10elasticsearch.bean.Book;
import com.springboot.demo10elasticsearch.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class Demo10ElasticsearchApplicationTests {

    @Autowired
    JestClient jestClient;
    @Autowired
    BookRepository bookRepository;

    @Test
    void contextLoads() throws IOException {
        // 1、给es中索引（保存）文档
        Article article = new Article(4, "作者", "标题-好消息", "文章内容2");

        Index index = new Index.Builder(article).index("springbootdemo").type("news").build();

        jestClient.execute(index);
    }

    @Test
    public void search() throws IOException {
        // 查询表达式
        String json = "{\n" +
                "\t\"query\":{\n" +
                "\t\t\"match\":{\n" +
                "\t\t\t\"content\":\"内容\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
     // 构建搜索功能
        Search search = new Search.Builder(json).addIndex("springbootdemo").addType("news").build();
   // 执行
        SearchResult result = jestClient.execute(search);
        System.out.println(result.getJsonString());
    }

    // ------------spring data--------------
    @Test
    public void test02(){
        Book book = new Book(1,"呵呵哒","谁写的");
        bookRepository.index(book);
    }

    @Test
    public void test03(){
        //Book book = new Book(1,"呵呵哒","谁写的");
//        for (Book book : bookRepository.FindByBookNameLike("呵")) {
//            System.out.println(book);
//        }

    }
}
