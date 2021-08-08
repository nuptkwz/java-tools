package com.kwz.springbootesshopping.controller;

import com.kwz.springbootesshopping.service.IBookService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/status/{keyword}")
    public Boolean saveBooks(@PathVariable String keyword) {
        try {
            return bookService.parseBooks(keyword);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("save books error", e);
        }
        return false;
    }

    @GetMapping("/search/{keyword}")
    public List<Map<String, Object>> searchBooks(@PathVariable String keyword,
                                                 @RequestParam int pageNo,
                                                 @RequestParam int pageSize) {
        try {
            return bookService.searchBooks(keyword, pageNo, pageSize);
        } catch (IOException e) {
            log.error("get books info from es error", e);
            return new ArrayList<>();
        }
    }
}
