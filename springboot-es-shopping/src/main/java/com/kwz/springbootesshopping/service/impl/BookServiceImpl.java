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
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    @Override
    public List<Map<String, Object>> searchBooks(String keywords, int pageNo, int pageSize) throws IOException {
        if (pageNo <= 1) {
            pageNo = 1;
        }
        SearchRequest searchRequest = new SearchRequest("jd_books");
        //拼装searchSourceBuilder搜索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
                .query(QueryBuilders.matchQuery("title", keywords))
                .timeout(TimeValue.timeValueSeconds(60));
        //分页
        searchSourceBuilder.from(pageNo).size(pageSize);

        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        List<Map<String, Object>> resultMaps = new ArrayList<>();
        SearchHit[] hits = searchResponse.getHits().getHits();
        for (SearchHit searchHit : hits) {
            resultMaps.add(searchHit.getSourceAsMap());
        }
        return resultMaps;
    }
}
