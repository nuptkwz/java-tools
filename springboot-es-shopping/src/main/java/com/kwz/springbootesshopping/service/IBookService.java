package com.kwz.springbootesshopping.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Description
 * Date 2021/8/8 21:18
 * Created by kwz
 */
public interface IBookService {

    /**
     * Description 获取books数据（从网页上爬虫获得数据）
     * Param [keywords]
     * return java.lang.Boolean
     */
    Boolean parseBooks(String keywords) throws IOException;

    /**
     * Description 搜索书籍
     * Param [keywords, pageNo, pageSize]
     * return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String, Object>> searchBooks(String keywords, int pageNo, int pageSize)  throws IOException;
}
