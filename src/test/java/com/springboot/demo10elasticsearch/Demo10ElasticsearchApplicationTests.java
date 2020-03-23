package com.springboot.demo10elasticsearch;

import com.springboot.demo10elasticsearch.bean.Article;
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

    @Test
    void contextLoads() throws IOException {
        // 1、给es中索引（保存）文档
        Article article = new Article(1, "作者", "标题-好消息", "文章内容2");

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
}
