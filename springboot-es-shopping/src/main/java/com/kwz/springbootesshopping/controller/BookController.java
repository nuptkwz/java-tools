package com.kwz.springbootesshopping.controller;

import com.kwz.springbootesshopping.service.IBookService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Description
 * Date 2021/8/8 21:16
 * Created by kwz
 */
@RestController
@Slf4j
@RequestMapping("/books")
public class BookController {

    @Setter(onMethod_ = @Autowired)
    private IBookService bookService;

    @PostMapping("/status/{keyWords}")
    public Boolean saveBooks(@PathVariable String keyWords) {
        try {
            return bookService.parseBooks(keyWords);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("save books error", e);
        }
        return false;
    }
}
