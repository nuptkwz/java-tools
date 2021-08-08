package com.kwz.springbootesshopping.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description
 * Date 2021/8/8 21:03
 * Created by kwz
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String title;
    private String price;
    private String pictureUrl;
}
