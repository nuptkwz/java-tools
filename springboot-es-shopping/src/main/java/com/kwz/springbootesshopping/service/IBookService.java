package com.kwz.springbootesshopping.service;

import java.io.IOException;

/**
 * Description
 * Date 2021/8/8 21:18
 * Created by kwz
 */
public interface IBookService {

    Boolean parseBooks(String keywords) throws IOException;
}
