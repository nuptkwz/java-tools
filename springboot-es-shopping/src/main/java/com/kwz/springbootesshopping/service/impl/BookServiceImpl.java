package com.kwz.springbootesshopping.service.impl;

import com.alibaba.fastjson.JSON;
import com.kwz.springbootesshopping.module.Book;
import com.kwz.springbootesshopping.service.IBookService;
import com.kwz.springbootesshopping.utils.HtmlParseUtil;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description
 * Date 2021/8/8 21:19
 * Created by kwz
 */
@Service
@Slf4j
public class BookServiceImpl implements IBookService {

    @Setter(onMethod_ = @Autowired)
    private RestHighLevelClient restHighLevelClient;

    //解析网页数据放入es索引中
    @Override
    public Boolean parseBooks(String keywords) throws IOException {
        List<Book> books = HtmlParseUtil.getJdBooks(keywords);
        //将获取的数据批量放入es中
        BulkRequest bulkRequest = new BulkRequest().timeout("5m");
        books.forEach(
                book -> bulkRequest.add(new IndexRequest("jd_books").source(JSON.toJSONString(book), XContentType.JSON))
        );
        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        return !bulkResponse.hasFailures();
    }
}
